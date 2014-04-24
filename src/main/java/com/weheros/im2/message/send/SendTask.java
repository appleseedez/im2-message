/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.message.send;

import com.weheros.im2.message.domain.Message;

/**
 * @ClassName: Sender
 * @author Administrator
 * @date 2014年4月2日 下午3:33:10
 */
public class SendTask implements Runnable {
	private Message message;
	

	public SendTask(Message message) {
		this.message=message;
	}

	@Override
	public void run() {
		// send to signal server.
		ISender sender=new SignalSender();
		sender.sendToSignal(message);
		
	}

}
