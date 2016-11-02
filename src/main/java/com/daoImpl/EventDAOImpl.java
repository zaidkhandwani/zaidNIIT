
package com.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.dao.EventDAO;
import com.model.Event;

@Repository("eventDAOImpl")
public class EventDAOImpl implements EventDAO {
	@Autowired
	Event event;

	@Autowired
	SessionFactory sessionFactory;

	public EventDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public EventDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Event> list() {

		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")

		List<Event> EventList = session.createQuery("from Event").list();
		System.out.println("--------->>>>>> Query Fired");
		session.close();
		System.out.println("--------->>>>>> Returning Event");
		return EventList;
	}
	
	
	@Transactional
	public void saveOrUpdate(Event event) {

		sessionFactory.getCurrentSession().saveOrUpdate(event);

	}

	@Transactional
	public void save(Event event) {

		sessionFactory.getCurrentSession().save(event);
		System.out.println("-@@@@@@@@@@@@@@@@@@@@@--------- .save event query fired");
	}

	@Transactional
	public void update(Event event) {

		sessionFactory.getCurrentSession().update(event);
		System.out.println("-@@@@@@@@@@@@@@@@@@@@@--------- .update query fired");
	}

	@Transactional
	public void delete(String id) {
		Event EventToDelete = new Event();
		EventToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(EventToDelete);
	}

	@Transactional
	public Event get(String id) {
		System.out.println("----------------->>> Id received = " + id);

		String hql = "from Event where id= '" + id + "'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("---------------------Get by id query fired");
		@SuppressWarnings("unchecked")
		List<Event> list = (List<Event>) query.list();

		if (list != null && !list.isEmpty()) {
			System.out.println("---------------------Returning Data");
			return list.get(0);

		}
		System.out.println("---------------------Returning Null");
		return null;
	}
	

}
