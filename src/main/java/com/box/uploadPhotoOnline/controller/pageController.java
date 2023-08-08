package com.box.uploadPhotoOnline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageController {
	
	@GetMapping("/")
	public String getIndexPage() {
		return "index";
	}
	
	@GetMapping("/signin")
	public String getSignin() {
		return "SignIn";
	}
	
	@GetMapping("/homePage")
	public String getHomePage(Model model) {
		model.addAttribute("active_message", "active");
		return "homepage";
	}
	
	@GetMapping("/gallery")
	public String getGallery(Model model) {
		model.addAttribute("active_message", "active");
		return "gallery";
	}
	

	
	

}
