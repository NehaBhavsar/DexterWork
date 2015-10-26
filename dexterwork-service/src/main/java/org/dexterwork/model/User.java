package org.dexterwork.model;

import org.dexterwork.entity.MstRole;

public class User {

	private int userId;
	private String userName;
	private String passWord;
	private MstRole mstRole;
	public User() {
		super();
	}	

	public User( int userId,String userName, String passWord) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public MstRole getRole() {
		return mstRole;
	}

	public void setRole(MstRole role) {
		this.mstRole = role;
	}

	
	

}
