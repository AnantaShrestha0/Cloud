package com.box.uploadPhotoOnline.service.impl;

import java.util.List;

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
	public UserModel sameUsernameSearch(String sendEmail) {
		UserModel userModel=userRep.findByEmail(sendEmail);
		return userModel;
	}

	@Override
	public void saveUser(UserModel userModel) {
		// TODO Auto-generated method stub
		userRep.save(userModel);
	}

	

	@Override
	public UserModel findUser(UserModel userModel) {
		String email=userModel.getEmail();
		String password=userModel.getPassword();
		return userRep.findByEmailAndPassword(email,password);
	}

	@Override
	public void uploadImages(List<UserModel> userModels) {
		// TODO Auto-generated method stub
		userRep.saveAll(userModels);
	}

}
