package com.adrianaden.app.exception;

public class JwtExceptionHandler extends Exception {
	
	public JwtExceptionHandler() {
		super("Unauthorization Token");
	}
	public JwtExceptionHandler(String message) {
		super(message);
	}
}
