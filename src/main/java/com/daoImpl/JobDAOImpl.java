
package com.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.dao.JobDAO;
import com.model.Job;

@Repository("jobDAOImpl")
public class JobDAOImpl implements JobDAO {
	@Autowired
	Job job;

	@Autowired
	SessionFactory sessionFactory;

	public JobDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public JobDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Job> list() {

		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")

		List<Job> JobList = session.createQuery("from Job").list();
		System.out.println("--------->>>>>> Query Fired");
		session.close();
		System.out.println("--------->>>>>> Returning Job");
		return JobList;
	}
	
	
	@Transactional
	public void saveOrUpdate(Job job) {

		sessionFactory.getCurrentSession().saveOrUpdate(job);

	}

	@Transactional
	public void save(Job job) {

		sessionFactory.getCurrentSession().save(job);
		System.out.println("-@@@@@@@@@@@@@@@@@@@@@--------- .save job query fired");
	}

	@Transactional
	public void update(Job job) {

		sessionFactory.getCurrentSession().update(job);
		System.out.println("-@@@@@@@@@@@@@@@@@@@@@--------- .update query fired");
	}

	@Transactional
	public void delete(String id) {
		Job JobToDelete = new Job();
		JobToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(JobToDelete);
	}

	@Transactional
	public Job get(String id) {
		System.out.println("----------------->>> Id received = " + id);

		String hql = "from Job where id= '" + id + "'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("---------------------Get by id query fired");
		@SuppressWarnings("unchecked")
		List<Job> list = (List<Job>) query.list();

		if (list != null && !list.isEmpty()) {
			System.out.println("---------------------Returning Data");
			return list.get(0);

		}
		System.out.println("---------------------Returning Null");
		return null;
	}
	

}
