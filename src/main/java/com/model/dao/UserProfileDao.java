package com.model.dao;

import com.model.UserProfile;

public interface UserProfileDao {
	public void addProfile(UserProfile profile);
	/*public void editProfile(UserProfile profile);
	public void deleteProfile(UserProfile profile);*/
	public UserProfile getProfile(String profileId);
}
