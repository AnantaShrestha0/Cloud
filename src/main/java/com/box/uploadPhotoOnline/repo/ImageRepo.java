package com.box.uploadPhotoOnline.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.box.uploadPhotoOnline.model.ImageModel;

public interface ImageRepo extends JpaRepository<ImageModel, Integer>{

}
