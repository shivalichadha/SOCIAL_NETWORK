package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.Authorization;
import com.model.dao.impl.AuthorizationDaoImpl;

@Service
public class AuthorizationService {
	@Autowired
	AuthorizationDaoImpl dao;
	
	public void addRole(Authorization role){
		dao.addRole(role);
	}
}
