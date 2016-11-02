package com.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

import com.base.BaseDomain;

@Entity
@Table(name = "JOB")
@Component
public class Job extends BaseDomain{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String title;
	private String companyName;
	private String description;
	private String location;
	private int vacancies;
	private String jobPostedOn;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getVacancies() {
		return vacancies;
	}
	public void setVacancies(int vacancies) {
		this.vacancies = vacancies;
	}
	public String getJobPostedOn() {
		return jobPostedOn;
	}
	public void setJobPostedOn(String jobPostedOn) {
		this.jobPostedOn = jobPostedOn;
	}

}
	
	
	

