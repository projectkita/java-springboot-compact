package com.adrianaden.app.response;

public class ResponseBody {
	private int responseCode;
	private String messenge;
	private Object data;
	
	public ResponseBody(ResponseCode responseCode, String messenge,  Object data) {
		this.setResponseCode(responseCode);
		this.setMessenge(messenge);
		this.setData(data);
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(ResponseCode responseCode) {
		this.responseCode = responseCode.getValue();
	}

	public String getMessenge() {
		return messenge;
	}

	public void setMessenge(String messenge) {
		this.messenge = messenge;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
