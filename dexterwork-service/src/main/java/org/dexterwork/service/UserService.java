package org.dexterwork.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.dexterwork.dao.UserDao;
import org.dexterwork.entity.MstUser;
import org.dexterwork.model.RespCode;
import org.dexterwork.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
//(readOnly = true)

public class UserService {
	
	Logger logger = Logger.getLogger(UserService.class);
	@Autowired
	UserDao userDao;
	
	@Transactional
	public int createUser(MstUser user) {
		System.out.println("Inside User created service :" +user);
		return userDao.createUser(user);
	}

	public List<User> getAllUser() {
		List<User> userList = userDao.getAllUser();
		return userList;
	}

	public MstUser getUserById(int userId) {
		System.out.println("Inside get User by id service.");
		return userDao.getUserById(userId);
	}

	public RespCode deleteUser(int userId) {
		RespCode result = userDao.deleteUserById(userId);
		return result;
		
	}


}
