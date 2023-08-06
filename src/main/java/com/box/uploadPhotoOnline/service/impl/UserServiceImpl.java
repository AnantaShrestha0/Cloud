package com.box.uploadPhotoOnline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.box.uploadPhotoOnline.model.UserModel;
import com.box.uploadPhotoOnline.repo.UserRep;
import com.box.uploadPhotoOnline.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRep userRep;
	@Override
	public void signIn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void signUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserModel sameUsernameSearch(String sendEmail) {
		UserModel userModel=userRep.findByEmail(sendEmail);
		return userModel;
	}

	@Override
	public void saveUser(UserModel userModel) {
		// TODO Auto-generated method stub
		
	}

}
