package com.model.dao.impl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Authentication;
//import com.model.UserProfile;
import com.model.dao.AuthenticationDao;

@Repository

public class AuthenticationDaoImpl implements AuthenticationDao{

	@Autowired
	private SessionFactory sessionFactory;
	public void addUser(Authentication user) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(user);
		session.flush();
		tx.commit();		
	}
	public Authentication getProfile(String username){		
				
		return (Authentication)sessionFactory.getCurrentSession().get(Authentication.class, username);		
		
	}
	
	public void updateProfile(Authentication profile,String userName){
		Session session=sessionFactory.getCurrentSession();
		//Transaction t=session.beginTransaction();
		System.out.println("---updating profile------");		
		Authentication p=(Authentication)session.get(Authentication.class,userName);
		System.out.println(p+" "+profile);
		p.setContact(profile.getContact());		
		p.setAddress(profile.getAddress());
		p.setContact(profile.getContact());
		p.setDob(profile.getDob());
		p.setEducation(profile.getEducation());
		p.setEmail(profile.getEmail());
		p.setFirstName(profile.getFirstName());
		p.setLastName(profile.getLastName());
		p.setGender(profile.getGender());
		session.saveOrUpdate(p);
		//session.flush();
		//t.commit();
		//session.close();
		
	}
}

