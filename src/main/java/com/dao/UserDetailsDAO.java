package com.dao;

import java.util.List;

import com.model.UserDetails;

public interface UserDetailsDAO {

	public List<UserDetails> listPending();
	
	public List<UserDetails> listApproved();

	public UserDetails get(String id);

	public void saveOrUpdate(UserDetails userDetails);
	
	public void save(UserDetails userDetails);
	
	public void update(UserDetails userDetails);

	public void delete(String id);

	public UserDetails validate(String userid, String password);

}
