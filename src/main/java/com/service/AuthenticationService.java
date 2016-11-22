package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Authentication;
import com.model.UserProfile;
import com.model.dao.impl.AuthenticationDaoImpl;

@Transactional
@Service
public class AuthenticationService {
	@Autowired
	AuthenticationDaoImpl dao;
	
	public void addUser(Authentication user){
		dao.addUser(user);
	}
	public Authentication getProfile(String username){
		return dao.getProfile(username);
		
	}
	public void updateProfile(Authentication profile,String userName){
		 dao.updateProfile(profile,userName);
	}	
}
