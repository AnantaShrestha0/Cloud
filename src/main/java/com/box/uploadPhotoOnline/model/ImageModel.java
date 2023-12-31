package com.box.uploadPhotoOnline.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Image_Details")
public class ImageModel {

	@Id
	@GeneratedValue
	private int id;
	private int userid;
	private String photoname;
	private String date;
}
