package com.demo.exception;

public class NoSuchFrieneExistException extends RuntimeException {

	String massage;

	public NoSuchFrieneExistException() {
		super();
	}

	public NoSuchFrieneExistException(String massage) {
		super(massage);
		this.massage = massage;
	}
}
