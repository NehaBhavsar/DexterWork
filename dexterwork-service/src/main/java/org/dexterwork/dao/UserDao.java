package org.dexterwork.dao;

import java.util.List;

import org.dexterwork.entity.MstUser;
import org.dexterwork.model.RespCode;
import org.dexterwork.model.User;

public interface UserDao {

	int createUser(MstUser user);

	List<User> getAllUser();

	MstUser getUserById(int userId);

	RespCode deleteUserById(int userId);
}
