
package com.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDetailsDAO;
import com.model.UserDetails;

import ch.qos.logback.core.net.SyslogOutputStream;

@Repository("userDAOImpl")
public class UserDetailsDAOImpl implements UserDetailsDAO {
	@Autowired
	UserDetails userDetails;

	@Autowired
	SessionFactory sessionFactory;

	public UserDetailsDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public UserDetailsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<UserDetails> listPending() {

		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")

		List<UserDetails> UserDetailsList = session.createQuery("from UserDetails where status = 'Pending'").list();
		System.out.println("--------->>>>>> Query Fired");
		session.close();
		System.out.println("--------->>>>>> Returning UserDetails");
		return UserDetailsList;
	}
	
	@Transactional
	public List<UserDetails> listApproved() {

		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")

		List<UserDetails> UserDetailsList = session.createQuery("from UserDetails where status = 'Approved'").list();
		System.out.println("--------->>>>>> Query Fired");
		session.close();
		System.out.println("--------->>>>>> Returning UserDetails");
		return UserDetailsList;
	}

	@Transactional
	public void saveOrUpdate(UserDetails userDetails) {

		sessionFactory.getCurrentSession().saveOrUpdate(userDetails);

	}

	@Transactional
	public void save(UserDetails userDetails) {

		sessionFactory.getCurrentSession().save(userDetails);
		System.out.println("-@@@@@@@@@@@@@@@@@@@@@--------- .save query fired");
	}

	@Transactional
	public void update(UserDetails userDetails) {

		sessionFactory.getCurrentSession().update(userDetails);
		System.out.println("-@@@@@@@@@@@@@@@@@@@@@--------- .update query fired");
	}

	@Transactional
	public void delete(String id) {
		UserDetails UserDetailsToDelete = new UserDetails();
		UserDetailsToDelete.setName(id);
		sessionFactory.getCurrentSession().delete(UserDetailsToDelete);
	}

	@Transactional
	public UserDetails validate(String username, String password) {
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@ in validate implementation");
		String hql = "from UserDetails where userid= '" + username + "' and " + " password ='" + password + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@  Query fired");
		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) query.list();

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}

	

	// String hql = "from UserDetails where uname='" +id+ "'";

	@Transactional
	public UserDetails get(String id) {
		System.out.println("----------------->>> Id received = " + id);

		String hql = "from UserDetails where email= '" + id + "'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("---------------------Get by id query fired");
		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) query.list();

		if (list != null && !list.isEmpty()) {
			System.out.println("---------------------Returning Data");
			return list.get(0);

		}
		System.out.println("---------------------Returning Null");
		return null;
	}
	

}
