package com.model.dao.impl;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.Forum;
import com.model.dao.ForumDao;

@Repository
public class ForumDaoImpl implements ForumDao{
	@Autowired
	SessionFactory sessionFactory;
	public void addForum(Forum f) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(f);
		session.flush();
		tx.commit();		
	}
	public List viewAllForums() {
		return sessionFactory.getCurrentSession().createQuery("from Forum").list();		
	}
	public void deleteForum(int topicId) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Forum forum=(Forum)session.get(Forum.class, new Integer(topicId));
		session.delete(forum);
		session.flush();
		tx.commit();
	}
	
}
