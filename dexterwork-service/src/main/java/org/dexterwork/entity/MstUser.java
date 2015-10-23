package org.dexterwork.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the mst_user database table.
 * 
 */
@Entity
@Table(name="mst_user")
@NamedQuery(name="MstUser.findAll", query="SELECT m FROM MstUser m")
public class MstUser  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;

	@Column(name="pass_code")
	private String passCode;

	@Column(name="user_name")
	private String userName;

	//bi-directional many-to-one association to MstRole
	@ManyToOne
	@JoinColumn(name="role_id")
	private MstRole mstRole;

	public MstUser() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassCode() {
		return this.passCode;
	}

	public void setPassCode(String passCode) {
		this.passCode = passCode;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public MstRole getMstRole() {
		return this.mstRole;
	}

	public void setMstRole(MstRole mstRole) {
		this.mstRole = mstRole;
	}

}