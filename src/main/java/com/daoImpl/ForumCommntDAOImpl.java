
package com.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.dao.ForumCommentDAO;
import com.model.ForumComment;

@Repository("forumCommentDAOImpl")
public class ForumCommntDAOImpl implements ForumCommentDAO {
	@Autowired
	ForumComment forumComment;

	@Autowired
	SessionFactory sessionFactory;

	public ForumCommntDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public ForumCommntDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<ForumComment> list() {

		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")

		List<ForumComment> ForumCommentList = session.createQuery("from ForumComment").list();
		System.out.println("--------->>>>>> Query Fired");
		session.close();
		System.out.println("--------->>>>>> Returning ForumComment");
		return ForumCommentList;
	}
	
	
	@Transactional
	public void saveOrUpdate(ForumComment forumComment) {

		sessionFactory.getCurrentSession().saveOrUpdate(forumComment);

	}

	@Transactional
	public void save(ForumComment forumComment) {

		sessionFactory.getCurrentSession().save(forumComment);
		System.out.println("-@@@@@@@@@@@@@@@@@@@@@--------- .save forumComment query fired");
	}

	@Transactional
	public void update(ForumComment forumComment) {

		sessionFactory.getCurrentSession().update(forumComment);
		System.out.println("-@@@@@@@@@@@@@@@@@@@@@--------- .update query fired");
	}

	@Transactional
	public void delete(String id) {
		ForumComment ForumCommentToDelete = new ForumComment();
		ForumCommentToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(ForumCommentToDelete);
	}

	@Transactional
	public ForumComment get(String id) {
		System.out.println("----------------->>> Id received = " + id);

		String hql = "from ForumComment where id= '" + id + "'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("---------------------Get by id query fired");
		@SuppressWarnings("unchecked")
		List<ForumComment> list = (List<ForumComment>) query.list();

		if (list != null && !list.isEmpty()) {
			System.out.println("---------------------Returning Data");
			return list.get(0);

		}
		System.out.println("---------------------Returning Null");
		return null;
	}
	

}
