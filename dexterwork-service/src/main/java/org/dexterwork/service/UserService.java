package org.dexterwork.service;

import org.apache.log4j.Logger;
import org.dexterwork.dao.UserDao;
import org.dexterwork.entity.MstUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserService {
	
	Logger logger = Logger.getLogger(UserService.class);
	@Autowired
	UserDao userDao;
	
	@Transactional
	public int createUser(MstUser user) {
		System.out.println("Inside User created service :" +user);
		return userDao.createUser(user);
	}


}
