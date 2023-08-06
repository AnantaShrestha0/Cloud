package com.box.uploadPhotoOnline.model;

import org.springframework.web.bind.annotation.GetMapping;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name="User_Details")
public class UserModel {

	@Id
	@GeneratedValue
    private int id;
	private String fullName;
	private String email;
	private String password;
	@Transient
	private String conformpasword;
	
}
	
