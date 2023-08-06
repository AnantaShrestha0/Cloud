package com.box.uploadPhotoOnline.service;

import com.box.uploadPhotoOnline.model.UserModel;

public interface UserService {

	void signIn();
	void signUp();
	void saveUser(UserModel userModel);
    UserModel sameUsernameSearch(String sendEmail);
	
	
}
