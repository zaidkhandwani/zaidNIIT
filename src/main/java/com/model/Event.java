package com.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

import com.base.BaseDomain;

@Entity
@Table(name = "EVENT")
@Component
public class Event extends BaseDomain{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String userId;
	private String title;
	private String description;
	private String location;
	private String dateOfEvent;
	private String eventPostedOn;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getDateOfEvent() {
		return dateOfEvent;
	}
	public void setDateOfEvent(String dateOfEvent) {
		this.dateOfEvent = dateOfEvent;
	}
	public String getEventPostedOn() {
		return eventPostedOn;
	}
	public void setEventPostedOn(String eventPostedOn) {
		this.eventPostedOn = eventPostedOn;
	}
	
	
	

}
	
	
	

