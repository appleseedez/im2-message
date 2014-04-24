/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.message.socket;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * @ClassName: ClientSessionHandler
 * @author Administrator
 * @date 2014年4月2日 下午5:38:38
 */
public class ClientSessionHandler extends IoHandlerAdapter {
	 private boolean finished;

	 
	    public boolean isFinished() {
	        return finished;
	    }

	    @Override
	    public void sessionOpened(IoSession session) {
	        // send summation requests
	      
	    }

	    @Override
	    public void messageReceived(IoSession session, Object message) {
	        // 
	    }

	    @Override
	    public void exceptionCaught(IoSession session, Throwable cause) {
	        session.close(true);
	    }
	
}
