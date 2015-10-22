package org.dexterwork.model;

public class AuthRes {

	private int userId;
	private RespCode respCode;

	public AuthRes() {
		super();
	}

	public AuthRes(int userId, RespCode respCode) {
		super();
		this.userId = userId;
		this.respCode = respCode;
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

}
