package com.pikitori.myapp.api.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.pikitori.myapp.service.FileIUploadService;
import com.pikitori.myapp.service.UserService;
import com.pikitori.myapp.vo.UserVo;

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
		
		List<UserVo> list = userService.getAllUsers();
		
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
	
	@Autowired
	FileIUploadService fileIUploadService;
	
	@RequestMapping("/fileupload")
	@ResponseBody
	public String fileupload(@RequestParam List<MultipartFile> file , @RequestParam String comment){
		System.out.println(comment);
		for(Object f: file){
		System.out.println(((MultipartFile)f).getOriginalFilename());
		}
		
		try {
			fileIUploadService.makemovie(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ok";
		
	}
}
