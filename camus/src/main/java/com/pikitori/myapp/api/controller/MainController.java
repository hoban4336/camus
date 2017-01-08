package com.pikitori.myapp.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pikitori.myapp.service.UserService;
import com.pikitori.myapp.vo.User;

@Controller
@RequestMapping("/user")
public class MainController {

	@RequestMapping("")
	@ResponseBody
	public String index(){
		return "index";
	}
	
	@Autowired
	UserService userService;
	
	@RequestMapping( "/list" )
	@ResponseBody
	public Object checkEmail() {
		
		List<User> list = userService.getAllUsers();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "result", "success" );
		map.put( "data", list ); 
		
		return map;
	}
	
	@RequestMapping("/get")
	public String getUser(@RequestParam String name , @RequestParam String email){
		System.out.println(email);
		System.out.println(name);
		
		return null;
		
	}
}
