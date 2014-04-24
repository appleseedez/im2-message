/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.message.socket;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.weheros.im2.message.LogService;

/**
 * @ClassName: SocketClient
 * @author Administrator
 * @date 2014年4月2日 下午5:30:27
 */
public class SocketClient {
	private static final long CONNECT_TIMEOUT = 30*1000L; // 30 seconds
	private static final String HOSTNAME="localhost";
	private static final int PORT=9000;
	
	public static void connectServer(String hostname,Integer port){
		 NioSocketConnector connector = new NioSocketConnector();
		    connector.setConnectTimeoutMillis(CONNECT_TIMEOUT);

		    connector.getFilterChain().addLast("logger", new LoggingFilter());
		    connector.getFilterChain().addLast("codec",	new ProtocolCodecFilter(new TextLineCodecFactory(Charset
							.forName("UTF-8"))));
		    connector.setHandler(new ClientSessionHandler());
		    IoSession session;

		    for (;;) {
		        try {
		            ConnectFuture future = connector.connect(new InetSocketAddress(HOSTNAME, PORT));
		            future.awaitUninterruptibly();
		            session = future.getSession();
		            break;
		        } catch (RuntimeIoException e) {
		        	LogService.error(SocketClient.class, "-------connect remote server["+HOSTNAME+":"+PORT+"] error------", e);
		        	// sleep 5 seconds
			        sleepnow();
		        }
		      
		    }

		    // wait until the summation is done
		    session.getCloseFuture().awaitUninterruptibly();
		    connector.dispose();
	}

	private static void sleepnow() {
		 try {
				Thread.sleep(5000);
			} catch (InterruptedException ex) {
				LogService.error(SocketClient.class, "-------socket client sleep error------", ex);
			    //throw ex;
				// TODO throw private exception
			}
		
	}

}
