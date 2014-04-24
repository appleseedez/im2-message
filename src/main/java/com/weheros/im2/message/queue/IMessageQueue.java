/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.message.queue;

import com.weheros.im2.message.domain.Message;

/**
 * @ClassName: IMessageQueue
 * @author Administrator
 * @date 2014年4月2日 下午2:23:00
 */
public interface IMessageQueue {
	public void push(Message message);
	public Message pop();
	

}
