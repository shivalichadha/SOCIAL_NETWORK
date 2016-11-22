package com.model.dao;

import com.model.Authentication;
import com.model.UserProfile;

public interface AuthenticationDao {
	public void addUser(Authentication user);
	public Authentication getProfile(String username);
	public void updateProfile(Authentication profile,String username);
}
