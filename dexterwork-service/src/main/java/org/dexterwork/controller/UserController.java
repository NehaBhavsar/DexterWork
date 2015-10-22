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
	
	/*static{
		userList.add(new User(1, "Joe", "1234"));
	}*/
	
	@RequestMapping(value="/create", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public AuthRes createUser (@RequestBody User user){
		if(null != user){
			userList.add(user);
			index++;
			return new AuthRes(index, RespCode.SUCCESS,"User Created successfully with id : "+index);
		}else{
			return new AuthRes(RespCode.FAILURE, "User not Found ");
		}
	}
	
}
