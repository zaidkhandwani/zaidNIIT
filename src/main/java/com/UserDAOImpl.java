package com;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	public UserDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<User> list() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<User> ProductList = session.createQuery("from User").list();
		session.close();
		return ProductList;
	}

	@Transactional
	public void saveOrUpdate(User user) {

		sessionFactory.getCurrentSession().save(user);

	}

	@Transactional
	public void delete(String id) {
		User UserToDelete = new User();
		UserToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(UserToDelete);
	}

	@Transactional
	public boolean validate(String username, String password) {
		String hql = "from User where uid= '" + username + "' and " + " upassword ='" + password + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();

		if (list != null && !list.isEmpty()) {
			return true;
		}

		return false;
	}
	
	@Transactional
	public boolean validateadmin(String username, String password) {
		String hql = "from User where uid= '" + username + "' and " + " admin ='1'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();

		if (list != null && !list.isEmpty()) {
			return true;
		}

		return false;
	}
	
	
	
	
	public com.User get(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
