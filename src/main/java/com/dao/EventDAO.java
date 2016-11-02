package com.dao;

import java.util.List;

import com.model.Event;

public interface EventDAO {

	public List<Event> list();
	
	public Event get(String id);
	
	public void saveOrUpdate(Event event);
	
	public void save(Event event);
	
	public void update(Event event);

	public void delete(String id);

}
