package org.dexterwork.model;

import org.dexterwork.entity.MstUser;

public class UserResp {

	private MstUser user;
	private RespCode respCode;
	private String msg;

	public UserResp() {
		super();
	}

	
	public UserResp(RespCode respCode, String msg) {
		super();
		this.respCode = respCode;
		this.msg = msg;
	}


	
	public UserResp(MstUser user, RespCode respCode, String msg) {
		super();
		this.user = user;
		this.respCode = respCode;
		this.msg = msg;
	}


	public MstUser getUser() {
		return user;
	}


	public void setUser(MstUser user) {
		this.user = user;
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
