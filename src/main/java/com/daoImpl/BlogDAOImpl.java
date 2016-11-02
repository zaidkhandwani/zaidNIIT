
package com.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.dao.BlogDAO;
import com.model.Blog;

@Repository("blogDAOImpl")
public class BlogDAOImpl implements BlogDAO {
	@Autowired
	Blog blog;

	@Autowired
	SessionFactory sessionFactory;

	public BlogDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Blog> listPending() {

		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")

		List<Blog> BlogList = session.createQuery("from Blog where status = 'Pending'").list();
		System.out.println("--------->>>>>> Query Fired");
		session.close();
		System.out.println("--------->>>>>> Returning Blog");
		return BlogList;
	}
	
	@Transactional
	public List<Blog> listApproved() {

		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")

		List<Blog> BlogList = session.createQuery("from Blog where status = 'Approved'").list();
		System.out.println("--------->>>>>> Query Fired");
		session.close();
		System.out.println("--------->>>>>> Returning Blog");
		return BlogList;
	}
	
	

	@Transactional
	public void saveOrUpdate(Blog blog) {

		sessionFactory.getCurrentSession().saveOrUpdate(blog);

	}

	@Transactional
	public void save(Blog blog) {

		sessionFactory.getCurrentSession().save(blog);
		System.out.println("-@@@@@@@@@@@@@@@@@@@@@--------- .save blog query fired");
	}

	@Transactional
	public void update(Blog blog) {

		sessionFactory.getCurrentSession().update(blog);
		System.out.println("-@@@@@@@@@@@@@@@@@@@@@--------- .update query fired");
	}

	@Transactional
	public void delete(String id) {
		Blog BlogToDelete = new Blog();
		BlogToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(BlogToDelete);
	}

	@Transactional
	public Blog get(String id) {
		System.out.println("----------------->>> Id received = " + id);

		String hql = "from Blog where id= '" + id + "'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("---------------------Get by id query fired");
		@SuppressWarnings("unchecked")
		List<Blog> list = (List<Blog>) query.list();

		if (list != null && !list.isEmpty()) {
			System.out.println("---------------------Returning Data");
			return list.get(0);

		}
		System.out.println("---------------------Returning Null");
		return null;
	}
	

}
