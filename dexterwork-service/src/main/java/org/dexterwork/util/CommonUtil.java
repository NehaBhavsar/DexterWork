package org.dexterwork.util;

import org.dexterwork.entity.MstRole;
import org.dexterwork.entity.MstUser;
import org.dexterwork.model.User;

public class CommonUtil {
	
	public static MstUser getMstUserFromVO(User user) {
		MstUser mstUser = new MstUser();
		mstUser.setUserName(user.getUserName());
		mstUser.setPassCode(user.getPassWord());
		MstRole role = new MstRole();
		role.setRoleId(1);
		role.setRoleName("Admin");
		role.setRoleDesc("Adminadmin");
		mstUser.setMstRole(role);
		return mstUser;
	}


}
