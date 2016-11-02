package com.dao;

import java.util.List;

import com.model.Friend;



public interface FriendDAO {

	public List<Friend> listPending();
	
	public List<Friend> listApproved();
	
	public Friend get(String id);
	
	public void saveOrUpdate(Friend friend);
	
	public void save(Friend friend);
	
	public void update(Friend friend);

	public void delete(String id);

}
