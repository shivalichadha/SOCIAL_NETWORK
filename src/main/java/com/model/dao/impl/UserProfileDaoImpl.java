package com.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.model.UserProfile;
import com.model.dao.UserProfileDao;

@Repository
public class UserProfileDaoImpl implements UserProfileDao{
	@Autowired
	private SessionFactory sessionFactory;	
	public void addProfile(UserProfile profile) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(profile);
		session.flush();
		tx.commit();		
	}	
	public UserProfile getProfile(String profileId){		
		
		return (UserProfile)sessionFactory.getCurrentSession().get(UserProfile.class, profileId);			
		
	}
	
}
