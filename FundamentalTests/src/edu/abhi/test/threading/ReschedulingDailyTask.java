package edu.abhi.test.threading;

import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of java based task scheduler
 * 
 * @author abhishek sarkar
 *
 */
public class ReschedulingDailyTask implements Runnable {

	protected static final Logger logger = LoggerFactory.getLogger(ReschedulingDailyTask.class);

	private final ScheduledExecutorService service;

	private final Runnable task;
	private final int hour;
	private final int min;
	private final int sec;

	private final AtomicBoolean active = new AtomicBoolean(false);
	private final AtomicBoolean scheduled = new AtomicBoolean(false);

	public ReschedulingDailyTask(final ScheduledExecutorService service,
			final Runnable task, final int hour) {
		this (service, task, hour, 0, 0);
	}

	public ReschedulingDailyTask(final ScheduledExecutorService service,
			final Runnable task, final int hour, final int min, final int sec) {
		this.service = service;
		this.task = task;
		this.hour = hour;
		this.min = min;
		this.sec = sec;

	}

	public void enable() {
		if (!active.getAndSet(true)) {
			// was not enabled:
			reSchedule();
		}
	}

	public void disable() {
		active.getAndSet(false);
	}

	private void reSchedule() {
		if (!scheduled.getAndSet(true)) {
			logger.info("scheduling");
			Calendar calendar = Calendar.getInstance();
			long now = calendar.getTimeInMillis();
			calendar.set(Calendar.HOUR, hour);
			calendar.set(Calendar.MINUTE, min);
			calendar.set(Calendar.SECOND, sec);
			calendar.set(Calendar.MILLISECOND, 0);
			while (calendar.getTimeInMillis() < now) {
				// scheduled in the past, go forward one day....
				calendar.add(Calendar.SECOND, 5);
			}

			// for debug, if needed....
			System.out.println("Reschedule for " + calendar.getTimeInMillis()
			        + " (in " + (calendar.getTimeInMillis() - now) + "ms)" );

			// set ourselves up to run at a given time.
			service.schedule(this, calendar.getTimeInMillis() - now, TimeUnit.MILLISECONDS);
			logger.info("after scheduling");
		}

	}

	@Override
	public void run() {
		// since we are running, we are no longer scheduled...
		scheduled.set(false);

		// we may have been disabled after we were enabled ...
		// you can't cancel the schedule, but you can ignore the task...
		if (!active.get()) {
			return;
		}

		// we were active, and we run the task, and force the reschedule.
		try {
			task.run();
		} finally {
			logger.info("in finally");
			reSchedule();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(1, new DaemonThreadFactory());
		Calendar cal = Calendar.getInstance();
		System.out.println("Time now: " + cal.getTimeInMillis());
		cal.add(Calendar.SECOND, 5);
		cal.set(Calendar.MILLISECOND, 0);
		System.out.println("Execute at: " + cal.getTimeInMillis());
		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		final Object lock = new Object();
		Runnable task = new Runnable() {

			@Override
			public void run() {
				System.out.println("Time is " + Calendar.getInstance().getTimeInMillis());
				Runtime rt = Runtime.getRuntime();
				try {
					Scanner sc = new Scanner(rt.exec("ping google.com -t").getInputStream());
					System.out.println(sc.nextLine());
					System.out.println(sc.nextLine());
					System.out.println(sc.nextLine());
					System.out.println(sc.nextLine());
					System.out.println(sc.nextLine());
					sc.close();
					logger.info("After task within");
				} catch (IOException e) {
					e.printStackTrace();
				}
				synchronized(lock) {
					lock.notifyAll();
				}
			}
		};

		ReschedulingDailyTask daily = new ReschedulingDailyTask(service, task, hour, min, sec);
		daily.enable();

		System.out.println("Waiting");
		synchronized (lock) {
			lock.wait();
		}
		System.out.println("Done");
	}
}

final class DaemonThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable runnable) {
		Thread thread = new Thread(runnable, "Schedule Thread");
//		thread.setDaemon(true);
		return thread;
	}

}
