package com.box.uploadPhotoOnline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.box.uploadPhotoOnline.model.ImageModel;
import com.box.uploadPhotoOnline.repo.ImageRepo;
import com.box.uploadPhotoOnline.service.UploadService;

@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	private ImageRepo imageRepo;
	
	@Override
	public void addImage(ImageModel imageModel) {
		// TODO Auto-generated method stub
		imageRepo.save(imageModel);
	}



}
