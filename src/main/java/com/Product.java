package com;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Product")
@Component
public class Product {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue()
	private String id;
	private String pid;
	private String category;
	private String name;
	private String description;
	private long price;
	private String image;

    transient private MultipartFile imagepath;
	
    
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPid() {
		return pid;
	}



	public void setPid(String pid) {
		this.pid = pid;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public long getPrice() {
		return price;
	}



	public void setPrice(long price) {
		this.price = price;
	}



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
