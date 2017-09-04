package it.sella.bg.poll.dto;

import java.io.Serializable;

public class PollMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2702490018349505269L;

	String sender;
	String message;

	public String getSender() {
		return this.sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}



}
