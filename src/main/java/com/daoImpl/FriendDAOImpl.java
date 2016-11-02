
package com.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.dao.FriendDAO;
import com.model.Friend;

@Repository("friendDAOImpl")
public class FriendDAOImpl implements FriendDAO {
	@Autowired
	Friend friend;

	@Autowired
	SessionFactory sessionFactory;

	public FriendDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public FriendDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Friend> listPending() {

		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")

		List<Friend> FriendList = session.createQuery("from Friend where status = 'Pending'").list();
		System.out.println("--------->>>>>> Query Fired");
		session.close();
		System.out.println("--------->>>>>> Returning Friend");
		return FriendList;
	}
	
	@Transactional
	public List<Friend> listApproved() {

		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")

		List<Friend> FriendList = session.createQuery("from Friend where status = 'Approved'").list();
		System.out.println("--------->>>>>> Query Fired");
		session.close();
		System.out.println("--------->>>>>> Returning Friend");
		return FriendList;
	}
	
	

	@Transactional
	public void saveOrUpdate(Friend friend) {

		sessionFactory.getCurrentSession().saveOrUpdate(friend);

	}

	@Transactional
	public void save(Friend friend) {

		sessionFactory.getCurrentSession().save(friend);
		System.out.println("-@@@@@@@@@@@@@@@@@@@@@--------- .save friend query fired");
	}

	@Transactional
	public void update(Friend friend) {

		sessionFactory.getCurrentSession().update(friend);
		System.out.println("-@@@@@@@@@@@@@@@@@@@@@--------- .update query fired");
	}

	@Transactional
	public void delete(String id) {
		Friend FriendToDelete = new Friend();
		FriendToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(FriendToDelete);
	}

	@Transactional
	public Friend get(String id) {
		System.out.println("----------------->>> Id received = " + id);

		String hql = "from Friend where id= '" + id + "'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("---------------------Get by id query fired");
		@SuppressWarnings("unchecked")
		List<Friend> list = (List<Friend>) query.list();

		if (list != null && !list.isEmpty()) {
			System.out.println("---------------------Returning Data");
			return list.get(0);

		}
		System.out.println("---------------------Returning Null");
		return null;
	}
	

}
