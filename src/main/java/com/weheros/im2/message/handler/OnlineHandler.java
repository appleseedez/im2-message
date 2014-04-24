package com.weheros.im2.message.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.weheros.im2.message.domain.Message;
import com.weheros.im2.message.queue.IMessageQueue;


/**
 * @author Yang
 * @version 1.0
 * @created 27-03-2014 18:55:23
 */
@Service("onlineHandler")
public class OnlineHandler extends DefaultHandler {
    
	
	@Autowired
	@Qualifier("redisMessageQueue")
	IMessageQueue messageQueue;
	
	@Override
	public void handle(Message message) {
		if (message.getIsSendImmediately()) {
			// TODO send now
		} else {
			messageQueue.push(message);
		}
	}

}