package com.box.uploadPhotoOnline.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.box.uploadPhotoOnline.model.ImageModel;
import com.box.uploadPhotoOnline.model.UserModel;
import com.box.uploadPhotoOnline.service.UploadService;
import com.box.uploadPhotoOnline.service.UserService;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/upload")
public class uploadImageController {
	
	
	@Autowired
	private UploadService uploadService;
	
	@Autowired 
	private UserService userService;

	//private final Path uploadPath = Path.of("src/main/resources/static/images/");
	

	
	
	@PostMapping("/uploadImage")
	public String postupload(@RequestParam MultipartFile image,Model model,HttpSession session) {
		
		if(session.getAttribute("validUser")==null) {
			return "SignIn";
		}
		
		UserModel user=(UserModel) session.getAttribute("validUser");
		
		LocalDate currentDate = LocalDate.now();
		String date = currentDate.toString();
		
		if(!image.isEmpty()) {
			try {
				String unqiue=generateUniqueFileName(image.getOriginalFilename());
				Files.copy(image.getInputStream(), Path.of("src/main/resources/static/images/"+unqiue), StandardCopyOption.REPLACE_EXISTING);
			    ImageModel imageModel=new ImageModel();
			    imageModel.setPhotoname(image.getOriginalFilename());
			    imageModel.setDate(date);
			    imageModel.setUserModel(user); // Set the user for the image
	            
	            user.getImageModels().add(imageModel); // Add the image to the user's list
	            userService.saveUser(user);
			model.addAttribute("message","File uploaded successfully");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "homepage";
	}
	
	 private String generateUniqueFileName(String originalFileName) {
	        String extension = StringUtils.getFilenameExtension(originalFileName);
	        return UUID.randomUUID().toString() + "." + extension;
	    }
	 
	 
	 @GetMapping("/gallery")
		public String getGallery(Model model,HttpSession session) {
			
			if(session.getAttribute("validUser")==null) {
				return "SignIn";
			}
			
			String[] imageName=new File("src/main/resources/static/images").list();
			model.addAttribute("imageNameList", imageName);
			model.addAttribute("active_message", "active");
			return "gallery";
		}
	
}
