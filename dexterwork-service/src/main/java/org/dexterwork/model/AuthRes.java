package org.dexterwork.model;

public class AuthRes {

	private int userId;
	private RespCode respCode;
	private String msg;

	public AuthRes() {
		super();
	}

	
	public AuthRes(RespCode respCode, String msg) {
		super();
		this.respCode = respCode;
		this.msg = msg;
	}


	public AuthRes(int userId, RespCode respCode,String msg) {
		super();
		this.userId = userId;
		this.respCode = respCode;
		this.msg = msg;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public RespCode getRespCode() {
		return respCode;
	}

	public void setRespCode(RespCode respCode) {
		this.respCode = respCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
