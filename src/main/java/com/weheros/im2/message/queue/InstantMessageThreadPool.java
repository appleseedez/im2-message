package com.weheros.im2.message.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Administrator
 * @version 1.0
 * @created 27-??-2014 12:11:09
 */
public class InstantMessageThreadPool {
	public static ExecutorService executor = Executors.newFixedThreadPool(200);

	
}