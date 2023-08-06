package com.box.uploadPhotoOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.box.uploadPhotoOnline.model.UserModel;
import com.box.uploadPhotoOnline.service.UserService;

@Controller
@RequestMapping("user/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/signin")
	public String getSignIn() {
		return "signin";
	}
	
	@GetMapping("/signup")
	public String getSignUp() {
		return "signup";
	}
	
	@PostMapping("/signin")
	public String postSignIn() {
		return "";
	}
	
	@PostMapping("/signup")
	public String postSignUp(UserModel userModel,Model model) {
		String password=userModel.getConformpasword();
		String conformpassword=userModel.getConformpasword();
		if(conformpassword.equals(password)) {
		   UserModel user=userService.sameUsernameSearch(userModel.getEmail());
		   if(user!=null) {
			   model.addAttribute("same_username_found","This email is already used");
			   return "signup";
		   }
		   
		}
		
		model.addAttribute("same_username_found","Password not matched");
		return "signup";
	}

}
