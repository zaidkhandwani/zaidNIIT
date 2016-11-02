package com.dao;

import java.util.List;

import com.model.Job;

public interface JobDAO {

	public List<Job> list();
	
	public Job get(String id);
	
	public void saveOrUpdate(Job job);
	
	public void save(Job job);
	
	public void update(Job job);

	public void delete(String id);

}
