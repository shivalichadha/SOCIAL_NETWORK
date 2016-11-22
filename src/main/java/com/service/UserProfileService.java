package com.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.UserProfile;
import com.model.dao.impl.UserProfileDaoImpl;
@Service
@Transactional
public class UserProfileService {
	@Autowired
	UserProfileDaoImpl dao;
	public void addProfile(UserProfile profile){
		dao.addProfile(profile);
		
	}
	public UserProfile getProfile(String profileId){
		return dao.getProfile(profileId);
		
	}
}
