package com;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository("carttDAO")
public class CartDAOImpl implements CartDAO {
	

	@Autowired
    SessionFactory sessionFactory;
	public CartDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Cart> list(String id) {
		System.out.println("in list method");
		String hql = "from Cart where cuserid='" +id +"' and Status = 'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();
		System.out.println("list query fired");  
		
		return list;
		  
	}
	
	@Transactional
	public void saveOrUpdate(Cart cart) {
	
	sessionFactory.getCurrentSession().saveOrUpdate(cart);
		
	}
	
	@Transactional
	public void save(Cart cart) {
	
	sessionFactory.getCurrentSession().save(cart);
		
	}
	
	@Transactional
	public void update(Cart cart) {
	
	sessionFactory.getCurrentSession().update(cart);
		
	}
	
	@Transactional
	public void delete(String id) {
		System.out.println("Deleting id="+id);
		Cart CartToDelete = new Cart();
		CartToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(CartToDelete);
	}

	@Transactional
	public Cart get(String id) {
		String hql = "from Cart where cuserid = '" + id +"' and Status = 'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}
	
	@Transactional
	public Long getTotalAmount(String id){
		String hql = "select sum(Product_Price) from cart where cuserid="+"'"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Long sum = (Long) query.uniqueResult();
		
		
		return sum;
	}
}
