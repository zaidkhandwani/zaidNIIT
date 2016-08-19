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
@Table(name="Cart")
@Component
public class Cart {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue()
	private String id;
	private String cuserid;
	private String cpid;
	private String cpcategory;
	private String cpname;
	private double cpprice;
	private int quantity;
	private String status;
	private String cpimage;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCuserid() {
		return cuserid;
	}
	public void setCuserid(String cuserid) {
		this.cuserid = cuserid;
	}
	public String getCpid() {
		return cpid;
	}
	public void setCpid(String cpid) {
		this.cpid = cpid;
	}
	public String getCpcategory() {
		return cpcategory;
	}
	public void setCpcategory(String cpcategory) {
		this.cpcategory = cpcategory;
	}
	public String getCpname() {
		return cpname;
	}
	public void setCpname(String cpname) {
		this.cpname = cpname;
	}
	public double getCpprice() {
		return cpprice;
	}
	public void setCpprice(double cpprice) {
		this.cpprice = cpprice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCpimage() {
		return cpimage;
	}
	public void setCpimage(String cpimage) {
		this.cpimage = cpimage;
	}
	

  }
