package com.box.uploadPhotoOnline.service;

import java.util.List;

import com.box.uploadPhotoOnline.model.UserModel;

public interface UserService {

//	void signIn();
//	void signUp();
	void saveUser(UserModel userModel);
    UserModel sameUsernameSearch(String sendEmail);
    UserModel findUser(UserModel userModel);
	void uploadImages(List<UserModel> userModels);
	
}
