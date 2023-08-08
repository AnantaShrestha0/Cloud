package com.box.uploadPhotoOnline.model;





import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
public class UserModel {

	@Id
	@GeneratedValue
    private int id;
	private String fullName;
	private String email;
	private String password;
	@Transient
	private String conformpassword;
	
	@OneToMany(mappedBy = "userModel", cascade = CascadeType.ALL)
    private List<ImageModel> imageModels = new ArrayList<>();
}
	
