/**
 * 
 */
package edu.abhi.test.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * An implementation of the use-case: one thread terminates complete jvm process
 * i.e. kills all other threads
 * 
 * @author abhishek sarkar
 *
 */
public class Service {
	
	static ExecutorService executorService = null;

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		List<Task> taskList = new ArrayList<>();
		taskList.add(new Task(5));
		taskList.add(new Task(3));
		taskList.add(new Task(8));
		taskList.add(new Task(4));
		
		final int effectiveThreadPoolSize = Math.min(taskList.size(), Runtime.getRuntime().availableProcessors() + 1);
		executorService = Executors.newFixedThreadPool(effectiveThreadPoolSize);
		executorService.invokeAll(taskList);
		executorService.shutdown();
	}
	
	public static void terminateAll() {
		executorService.shutdownNow();
	}

}
