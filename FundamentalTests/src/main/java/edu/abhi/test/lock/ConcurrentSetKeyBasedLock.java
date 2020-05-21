/**
 * 
 */
package edu.abhi.test.lock;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.collections4.keyvalue.MultiKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Sets;

/**
 * This is a Self made locking strategy for a particular key trying in more than
 * one thread but to be allowed for actual execution one thread at a time for a
 * specific key.
 * 
 * @author abhishek sarkar
 *
 */
public class ConcurrentSetKeyBasedLock {

	private static final Logger logger = LoggerFactory.getLogger(ConcurrentSetKeyBasedLock.class);

	private static Set<MultiKey<Object>> concurrentSet = Sets.newConcurrentHashSet();

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		List<Task> tasks = Arrays.asList(new Task(1), new Task(2), new Task(3), new Task(4));
		ExecutorService executor = Executors.newFixedThreadPool(tasks.size());
		executor.invokeAll(tasks);
		executor.shutdown();
	}

	/**
	 * This synchronized API puts a key only if it doesn't exist already.
	 * 
	 * @param key
	 * @return true, if only able to put the value successfully, i.e. doesn't exist
	 *         already.
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static synchronized <T> boolean putSuccessfully(T key) throws Exception {
		boolean contains = concurrentSet.contains(key);
		if (!contains) {
			logger.info("added");
			concurrentSet.add((MultiKey<Object>) key);
		}
		return !contains;
	}

	public static synchronized <T> boolean remove(T key) {
		logger.info("exit after removal");
		return concurrentSet.remove(key);
	}
}

class Task implements Callable<Object> {

	private static final Logger logger = LoggerFactory.getLogger(Task.class);

	private int n;

	public Task(int n) {
		this.n = n;
	}

	@Override
	public Object call() throws Exception {
		MultiKey<Object> key = new MultiKey<Object>(n % 2, "MT565");

		while (true) {
			if (ConcurrentSetKeyBasedLock.putSuccessfully(key)) {
				logger.info("inside");

				Thread.sleep(1000);

				ConcurrentSetKeyBasedLock.remove(key);
			} else
				continue;
//			Thread.sleep(10);
			break;
		}
		return key;
	}

}

///**
// * 
// */
//package edu.abhi.test.lock;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.concurrent.Callable;
//import java.util.concurrent.ConcurrentMap;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//import org.apache.commons.collections4.keyvalue.MultiKey;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.google.common.collect.Maps;
//
///**
// * @author abhis
// *
// */
//public class Demo {
//	
//	protected static final Logger logger = LoggerFactory.getLogger(Demo.class);
//
//	private static ConcurrentMap<MultiKey<Object>, MultiKey<Object>> concurrentMap = Maps.newConcurrentMap();
//
//	/**
//	 * @param args
//	 * @throws InterruptedException 
//	 */
//	public static void main(String[] args) throws InterruptedException {
//		
//		List<Task> tasks = Arrays.asList(new Task(), new Task());
//		ExecutorService executor = Executors.newFixedThreadPool(
//				Math.min(Runtime.getRuntime().availableProcessors(), tasks.size()));
//		executor.invokeAll(tasks);
//		executor.shutdown();
//	}
//	
//	public static synchronized MultiKey<Object> get(MultiKey<Object> key) throws Exception {
//		if(!concurrentMap.containsKey(key)) {
//			logger.info("added");
//			concurrentMap.put(key, key);
//		} else return null;
//		return concurrentMap.get(key);
//	}
//
//	public static synchronized MultiKey<Object> remove(MultiKey<Object> key) {
//		logger.info("exit after removal");
//		return concurrentMap.remove(key);
//	}
//}
//
//class Task implements Callable<Object> {
//
//	protected static final Logger logger = LoggerFactory.getLogger(Task.class);
//
//	@Override
//	public Object call() throws Exception {
//		MultiKey<Object> key = new MultiKey<Object>(5L, "MT565");
//		
//		while (true) {
//			try {
//				synchronized(Demo.get(key)) {
//					logger.info("inside");
//					
//					Thread.sleep(1000);
//					
//					Demo.remove(key);
//				}
//				Thread.sleep(10);
//				//break;
//			} catch (Exception e) {
//				//logger.info("waiting");
//			}
//		}
//		//return key;
//	}
//	
//}