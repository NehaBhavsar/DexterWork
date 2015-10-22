package org.dexterwork.controller;

import java.util.ArrayList;
import java.util.List;

import org.dexterwork.model.User;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

	public static List<User> userList = new ArrayList<User>();
	static{
		userList.add(new User(1, "Joe", "1234"));
	}
}
