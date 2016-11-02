
package com.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.dao.ForumDAO;
import com.model.Forum;

@Repository("forumDAOImpl")
public class ForumDAOImpl implements ForumDAO {
	@Autowired
	Forum forum;

	@Autowired
	SessionFactory sessionFactory;

	public ForumDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public ForumDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Forum> list() {

		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")

		List<Forum> ForumList = session.createQuery("from Forum").list();
		System.out.println("--------->>>>>> Query Fired");
		session.close();
		System.out.println("--------->>>>>> Returning Forum");
		return ForumList;
	}
	
	
	@Transactional
	public void saveOrUpdate(Forum forum) {

		sessionFactory.getCurrentSession().saveOrUpdate(forum);

	}

	@Transactional
	public void save(Forum forum) {

		sessionFactory.getCurrentSession().save(forum);
		System.out.println("-@@@@@@@@@@@@@@@@@@@@@--------- .save forum query fired");
	}

	@Transactional
	public void update(Forum forum) {

		sessionFactory.getCurrentSession().update(forum);
		System.out.println("-@@@@@@@@@@@@@@@@@@@@@--------- .update query fired");
	}

	@Transactional
	public void delete(String id) {
		Forum ForumToDelete = new Forum();
		ForumToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(ForumToDelete);
	}

	@Transactional
	public Forum get(String id) {
		System.out.println("----------------->>> Id received = " + id);

		String hql = "from Forum where id= '" + id + "'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("---------------------Get by id query fired");
		@SuppressWarnings("unchecked")
		List<Forum> list = (List<Forum>) query.list();

		if (list != null && !list.isEmpty()) {
			System.out.println("---------------------Returning Data");
			return list.get(0);

		}
		System.out.println("---------------------Returning Null");
		return null;
	}
	

}
