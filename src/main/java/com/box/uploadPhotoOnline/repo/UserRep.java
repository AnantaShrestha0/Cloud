package com.box.uploadPhotoOnline.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.box.uploadPhotoOnline.model.UserModel;

public interface UserRep extends JpaRepository<UserModel, Integer>{
	
	UserModel findByEmail(String email);

	
}
