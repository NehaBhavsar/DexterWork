package org.dexterwork.controller;

import java.util.ArrayList;
import java.util.List;

import org.dexterwork.model.UserResp;
import org.dexterwork.exception.UserNotFoundException;
import org.dexterwork.model.RespCode;
import org.dexterwork.model.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	public UserResp createUser (@RequestBody User user){
		if(null != user){
			user.setUserId(index);
			userList.add(user);
			index++;
			return new UserResp((index-1), RespCode.SUCCESS,"User Created successfully with id : "+(index-1));
		}else{
			return new UserResp(RespCode.FAILURE, "User not Found ");
		}
	}
	
	@RequestMapping(value = "/get" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> getAllUser() {
		return userList;
	}
	
	
	@RequestMapping(value = "/get/{userId}" , method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserResp getUserbyId(@PathVariable("userId") int userId ){
		for(User user :userList){
			if(user.getUserId() == userId){
				return new UserResp(userId, RespCode.SUCCESS, "User is found with id : "+user.getUserId());
			}
		}
		throw new UserNotFoundException();
	}

	
	
}
