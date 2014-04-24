/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.message.send;

import java.util.concurrent.FutureTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.weheros.im2.message.LogService;
import com.weheros.im2.message.queue.IMessageQueue;
import com.weheros.im2.message.queue.InstantMessageThreadPool;

/**
 * @ClassName: MessageSender
 * @author Administrator
 * @date 2014年4月2日 上午12:00:38
 */
public class MessageConsumeThread extends Thread {
	@Autowired
	@Qualifier("redisMessageQueue")
	IMessageQueue messageQueue;
	@Override
	public void run() {
		// pop the message from redis
		// many message one time
		InstantMessageThreadPool.executor.execute(new FutureTask(new SendTask(messageQueue.pop()),null));	
		
		try {
			// send message to Signal server per 2 seconds if there has message in queue.			
			sleep(2000);
		} catch (InterruptedException e) {
			LogService.error(MessageConsumeThread.class, "--------MessageConsumeThread sleep error----------------", e);
		}
		
		
	}
}
