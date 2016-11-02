package com.dao;

import java.util.List;

import com.model.ForumComment;

public interface ForumCommentDAO {

	public List<ForumComment> list();
	
	public ForumComment get(String id);
	
	public void saveOrUpdate(ForumComment forumComment);
	
	public void save(ForumComment forumComment);
	
	public void update(ForumComment forumComment);

	public void delete(String id);

}
