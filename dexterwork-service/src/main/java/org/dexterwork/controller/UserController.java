package org.dexterwork.controller;

import java.util.ArrayList;
import java.util.List;

import org.dexterwork.entity.MstUser;
import org.dexterwork.exception.UserNotFoundException;
import org.dexterwork.model.RespCode;
import org.dexterwork.model.User;
import org.dexterwork.model.UserResp;
import org.dexterwork.service.UserService;
import org.dexterwork.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	//private int index =1;

	public static List<User> userList = new ArrayList<User>();
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/create", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserResp createUser (@RequestBody User user){
		System.out.println("Creating USer ---------------------------------");
		if(null != user){
			int userid = userService.createUser(CommonUtil.getMstUserFromVO(user));
//			user.setUserId(index);
//			userList.add(user);
//			index++;
			return new UserResp( RespCode.SUCCESS,"User Created successfully with id : "+userid);
		}else{
			return new UserResp(RespCode.FAILURE, "User not Found ");
		}
	}
	
	@RequestMapping(value = "/get" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> getAllUser() {
		List<User> userList = userService.getAllUser();
		return userList;
	}
	
	
	@RequestMapping(value = "/get/{userId}" , method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserResp getUserbyId(@PathVariable("userId") int userId ){
		
		MstUser user = userService.getUserById(userId);
		
		if(null != user)
			return new UserResp(user,RespCode.SUCCESS,"User found with id :"+user.getUserId());
		
//		for(User user :userList){
//			if(user.getUserId() == userId){
//				return new UserResp(userId, RespCode.SUCCESS, "User is found with id : "+user.getUserId());
//			}
//		}
		
		throw new UserNotFoundException();
	}


	@RequestMapping(value = "/delete/{userId}" , method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserResp deleteUser(@PathVariable("userId") int userId){
		
		
		RespCode result = userService.deleteUser(userId);
		if(result.equals(RespCode.SUCCESS)){
			return new UserResp(RespCode.SUCCESS,"User Deleted successfully with id : "+userId);
		}
		/*for(User user :userList){
			if(user.getUserId() == userId){
				userList.remove(user);
				return new UserResp( RespCode.SUCCESS, "User is deleted with id : "+userId);
			}
		}*/
		throw new UserNotFoundException();
	}

	
}
