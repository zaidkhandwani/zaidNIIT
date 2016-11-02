package com.model;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.base.BaseDomain;

@Entity
@Table(name = "USERDETAILS")
@Component
public class UserDetails extends BaseDomain{
	
	
	@Id
	
	private String userId;
	private String name;
	private String email;
	private String mobile;
	private String password;
	private String role;
	private String status;
	private String isOnline;
	private String image;

    transient private MultipartFile imagepath;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public MultipartFile getImagepath() {
		return imagepath;
	}
	public void setImagepath(MultipartFile imagepath) {
		this.imagepath = imagepath;
	}
	public String getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public  String getFilePath(String path1, String contextpath)
	{
		
		
		String fileName = null;
    	if (!imagepath.isEmpty()) {
            try {
            	
            	
                fileName = imagepath.getOriginalFilename();
                byte[] bytes = imagepath.getBytes();
                	String npath=path1+"\\resources\\"+ fileName;
  
        				BufferedOutputStream buffStream = 
                        new BufferedOutputStream(new FileOutputStream(new File(npath)));
                buffStream.write(bytes);
                buffStream.close();
               String dbfilename=contextpath+"/resources/"+fileName;
                
                this.setImage(dbfilename);
                return dbfilename;
            } catch (Exception e) {
                return "Upload Fail " + fileName + ": " + e.getMessage();
            }
        } else {
            return "File Empty";
        }
		
		
	}
	
	
	

	
}
