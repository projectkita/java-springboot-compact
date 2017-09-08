package com.adrianaden.app.response;

public enum ResponseCode {
	SUCCESS(20000001),
	SUCCESS_EMPTY_DATA(20000002),
	TOKEN_UNAUTHORIZED(40100001),
	SIGNATURE_UNAUTHORIZED(40100002),
	SERVER_INTERNAL_ERROR(50000001);
	
	private final int value;

    private ResponseCode(int value) {
        this.value = value;
    }
    
    public int getValue() {
    	return this.value;
    }
}
