package com.weheros.im2.message.domain;

import java.util.Set;

/**
 * Short message definition.
 * 
 * @author Yang
 * @version 1.0
 * @created 27-03-2014 18:55:20
 */
public class Message {
	/**
	 * such as text,picture,audio and so on.
	 */
	private String type;
	/**
	 * phone code of sender.
	 */
	private String sender;
	/**
	 * phone code of receiver. could be mutiple.
	 */
	private Set<String> receiver;
	/**
	 * it is text. or it is a url of audio,video,file.
	 */
	private String content;
	/**
	 * true, the short message is need to be send right now.
	 * false,the message will be push into queue and send to target user later.
	 */
	private Boolean isSendImmediately;
	/**
	 * true,the message will be send mutiple times after first failure.
	 *      the message should be persisted while send fail.
	 * 
	 */
	private Boolean isRetryAfterFail;
	/**
	 * true,online message.
	 * false,offline message.
	 *       the message should be persisted and some time the client will pull message from server.
	 */
	private Boolean isOnline;
    
	public Message(){
		this.isSendImmediately=false;
		this.isRetryAfterFail=true;
		this.isOnline=true;
	}

	public Boolean getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(Boolean isOnline) {
		this.isOnline = isOnline;
	}

	public Boolean getIsSendImmediately() {
		return isSendImmediately;
	}

	public void setIsSendImmediately(Boolean isSendImmediately) {
		this.isSendImmediately = isSendImmediately;
	}

	public Boolean getIsRetryAfterFail() {
		return isRetryAfterFail;
	}

	public void setIsRetryAfterFail(Boolean isRetryAfterFail) {
		this.isRetryAfterFail = isRetryAfterFail;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Set<String> getReceiver() {
		return receiver;
	}

	public void setReceiver(Set<String> receiver) {
		this.receiver = receiver;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}