package com.box.uploadPhotoOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.box.uploadPhotoOnline.model.UserModel;
import com.box.uploadPhotoOnline.service.UserService;

import jakarta.servlet.http.HttpSession;

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
	public String postSignIn(UserModel userModel,Model model,HttpSession httpSession) {
		UserModel user=userService.findUser(userModel);
		if(user==null) {
			model.addAttribute("error","Username password not matched");
			return "SignIn";
		}
		httpSession.setAttribute("validUser",user);
		httpSession.setMaxInactiveInterval(999999999);
		return "redirect:/homePage";
	}
	
	@PostMapping("/signup")
	public String postSignUp(UserModel userModel,Model model) {
		String password=userModel.getPassword();
		String conformpassword=userModel.getConformpassword();
		if(conformpassword.equals(password)) {
		   UserModel user=userService.sameUsernameSearch(userModel.getEmail());
		   if(user!=null) {
			   model.addAttribute("same_username_found","This email is already used");
			   return "signup";
		   }
		   
		   userService.saveUser(userModel);
		   return "SignIn.html";
		   
		}
		
		model.addAttribute("same_username_found","Password not matched");
		return "signup";
	}

}
