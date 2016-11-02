package com.dao;

import java.util.List;

import com.model.News;

public interface NewsDAO {

	public List<News> list();
	
	public News get(String id);
	
	public void saveOrUpdate(News news);
	
	public void save(News news);
	
	public void update(News news);

	public void delete(String id);

}
