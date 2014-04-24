/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.message.send;

import com.weheros.im2.message.domain.Message;

/**
 * @ClassName: ISender
 * @author Administrator
 * @date 2014年4月2日 下午3:51:02
 */
public interface ISender {
    
	public void sendToSignal(Message message);
}
