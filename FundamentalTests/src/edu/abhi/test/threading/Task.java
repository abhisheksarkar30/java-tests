package edu.abhi.test.threading;


import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task implements Callable<String>{
	
	protected static final Logger logger = LoggerFactory.getLogger(Task.class);

	int w;
	
	public Task(int wait) {
		w = wait;
	}

	@Override
	public String call() throws Exception {
		logger.info("Thread started with w = " + w);
		for(int index = 0; index < w; index++)
			Thread.sleep(1000);
		logger.info("Thread ended with w = " + w);
//		Service.terminateAll();
		System.exit(0);
		return null;
	}

}
