package com;

import java.util.List;




public interface CartDAO {


	public List<Cart> list(String id);

	public Cart get(String id);

	public void save(Cart cart);
	
	public void update(Cart cart);

	public void delete(String id);

	public void saveOrUpdate(Cart cart);

	public Long getTotalAmount(String id); 
}
