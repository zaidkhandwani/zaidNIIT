package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

import com.base.BaseDomain;

@Entity
@Table(name = "FORUMCOMMENT")
@Component
public class ForumComment extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String userId;
	private String comment;
	private String dateCommentedOn;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDateCommentedOn() {
		return dateCommentedOn;
	}
	public void setDateCommentedOn(String dateCommentedOn) {
		this.dateCommentedOn = dateCommentedOn;
	}


}
