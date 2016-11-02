package com.dao;

import java.util.List;

import com.model.Blog;

public interface BlogDAO {

	public List<Blog> listPending();
	
	public List<Blog> listApproved();
	
	public Blog get(String id);
	
	public void saveOrUpdate(Blog blog);
	
	public void save(Blog blog);
	
	public void update(Blog blog);

	public void delete(String id);

}
