/**
 * Copyright (c) 2013-2014 HZCW Technology Inc,All Rights Reserved.
 */
	
package com.weheros.im2.message.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.weheros.im2.message.domain.Message;


/**
 * Handle messeage queue.
 * want to store message and queue into redis.
 * @ClassName: RedisMessageQueue
 * @author Yang
 * @date 2014年3月27日 下午7:26:12
 */
@Service("redisMessageQueue")
public class RedisMessageQueue implements IMessageQueue{
	@Autowired
	private RedisTemplate<String, Message> redisTemplate;
	/*private static final Lock lock = new ReentrantLock();
    private static RedisMessageQueue messageQueue=null;
    
	public static RedisMessageQueue getInstance(){
		lock.lock();
		if(null==messageQueue){
			messageQueue=new RedisMessageQueue("redis-message-queue-thread");
		}
		lock.unlock();
		return messageQueue;
	}
	private RedisMessageQueue(String name){
		super(name);
	}*/
	
	
	public void push(Message message) {
		// could push into thread queue and then into redis.
		// push many recored into redis could get more higher performance.
		redisTemplate.boundListOps("common-message-queue").leftPush(message);
	}


	public Message pop() {
		//  Auto-generated method stub
		return redisTemplate.opsForList().rightPop("common-message-queue");
		
	}
	
	

}
