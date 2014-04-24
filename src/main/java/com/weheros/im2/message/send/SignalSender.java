/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.message.send;

import com.weheros.im2.message.domain.Message;

/**
 * @ClassName: RPCSender
 * @author Administrator
 * @date 2014年4月2日 下午3:52:55
 */
public class SignalSender implements ISender {

	@Override
	public void sendToSignal(Message message){
		// TODO RPC
		// find the signal server where the receiver connect.
		String signalServer="";
		String port="";
	}

}
