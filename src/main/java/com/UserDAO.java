package com;

import java.util.List;

public interface UserDAO {

	public List<User> list();

	public User get(String id);

	public void saveOrUpdate(User user);

	public void delete(String id);

	public boolean validate(String userid, String password);
	
	public boolean validateadmin(String username, String password);
	
	
}
