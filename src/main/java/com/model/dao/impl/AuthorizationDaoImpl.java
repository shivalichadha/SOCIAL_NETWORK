package com.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Authorization;
import com.model.dao.AuthorizationDao;

@Repository
public class AuthorizationDaoImpl implements AuthorizationDao{
	@Autowired
	private SessionFactory sessionFactory;
	public void addRole(Authorization role) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(role);
		session.flush();
		tx.commit();
		
		
	}

}
