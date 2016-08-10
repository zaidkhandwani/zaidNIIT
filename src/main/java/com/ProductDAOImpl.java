package com;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	

	@Autowired
    SessionFactory sessionFactory;
	public ProductDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Product> list() {
		 Session session = sessionFactory.openSession();  
		  @SuppressWarnings("unchecked")  
		  List<Product> ProductList = session.createQuery("from Product")  
		    .list();  
		  session.close();  
		  return ProductList; 
	}
	
	@Transactional
	public void saveOrUpdate(Product product) {
	
	sessionFactory.getCurrentSession().saveOrUpdate(product);
		
	}
	
	@Transactional
	public void save(Product product) {
	
	sessionFactory.getCurrentSession().saveOrUpdate(product);
		
	}
	
	@Transactional
	public void update(Product product) {
	
	sessionFactory.getCurrentSession().update(product);
		
	}
	
	@Transactional
	public void delete(String id) {
		Product ProductToDelete = new Product();
		ProductToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(ProductToDelete);
	}

	@Transactional
	public Product get(String id) {
		String hql = "from Product where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) query.list();
		
		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}
		
		return null;
	}


}
