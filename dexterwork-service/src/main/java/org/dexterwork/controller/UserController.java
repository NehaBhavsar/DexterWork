package org.dexterwork.controller;

import java.util.ArrayList;
import java.util.List;

import org.dexterwork.model.AuthRes;
import org.dexterwork.model.RespCode;
import org.dexterwork.model.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/users")
public class UserController {
	
	private int index =1;

	public static List<User> userList = new ArrayList<User>();
	
	
	@RequestMapping(value="/create", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public AuthRes createUser (@RequestBody User user){
		if(null != user){
			user.setUserId(index);
			userList.add(user);
			index++;
			return new AuthRes((index-1), RespCode.SUCCESS,"User Created successfully with id : "+(index-1));
		}else{
			return new AuthRes(RespCode.FAILURE, "User not Found ");
		}
	}
	
	@RequestMapping(value = "/getUser" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> getAllUser() {
		return userList;
	}
	
}
