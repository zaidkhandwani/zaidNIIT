
package com.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.dao.NewsDAO;
import com.model.News;

@Repository("newsDAOImpl")
public class NewsDAOImpl implements NewsDAO {
	@Autowired
	News news;

	@Autowired
	SessionFactory sessionFactory;

	public NewsDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public NewsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<News> list() {

		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")

		List<News> NewsList = session.createQuery("from News").list();
		System.out.println("--------->>>>>> Query Fired");
		session.close();
		System.out.println("--------->>>>>> Returning News");
		return NewsList;
	}
	
	
	@Transactional
	public void saveOrUpdate(News news) {

		sessionFactory.getCurrentSession().saveOrUpdate(news);

	}

	@Transactional
	public void save(News news) {

		sessionFactory.getCurrentSession().save(news);
		System.out.println("-@@@@@@@@@@@@@@@@@@@@@--------- .save news query fired");
	}

	@Transactional
	public void update(News news) {

		sessionFactory.getCurrentSession().update(news);
		System.out.println("-@@@@@@@@@@@@@@@@@@@@@--------- .update query fired");
	}

	@Transactional
	public void delete(String id) {
		News NewsToDelete = new News();
		NewsToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(NewsToDelete);
	}

	@Transactional
	public News get(String id) {
		System.out.println("----------------->>> Id received = " + id);

		String hql = "from News where id= '" + id + "'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("---------------------Get by id query fired");
		@SuppressWarnings("unchecked")
		List<News> list = (List<News>) query.list();

		if (list != null && !list.isEmpty()) {
			System.out.println("---------------------Returning Data");
			return list.get(0);

		}
		System.out.println("---------------------Returning Null");
		return null;
	}
	

}
