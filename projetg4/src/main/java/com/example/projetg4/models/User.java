package com.example.projetg4.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "User")
public class User {
	@Id 
	private String id ;
	private String email ; 
	private String password ; 
	private String fullname ;
	private String gender ;
	private String Adress;
	private String profileimage ;
	//private String token ;
	//private String tokentimeout ;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public User( String email, String password, String fullname, String gender , String Adress /*, String profileimage */) {
		super();
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.gender = gender;
		this.Adress = Adress ;
		//this.profileimage = profileimage;
	}
	public User() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProfileimage() {
		return profileimage;
	}
	public void setProfileimage(String profileimage) {
		this.profileimage = profileimage;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	



	
	
	
	
	
	
	
	
	
	
	
	

}
