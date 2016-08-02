package com;

import java.util.List;




public interface ProductDAO {


	public List<Product> list();

	public Product get(String id);

	public void save(Product product);
	
	public void update(Product product);

	public void delete(String id);

	public void saveOrUpdate(Product product);

}
