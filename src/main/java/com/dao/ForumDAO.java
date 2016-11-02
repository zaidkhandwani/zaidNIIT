package com.dao;

import java.util.List;

import com.model.Forum;

public interface ForumDAO {

	public List<Forum> list();
	
	public Forum get(String id);
	
	public void saveOrUpdate(Forum forum);
	
	public void save(Forum forum);
	
	public void update(Forum forum);

	public void delete(String id);

}
