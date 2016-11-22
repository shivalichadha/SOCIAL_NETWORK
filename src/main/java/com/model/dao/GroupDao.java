package com.model.dao;

import java.util.List;
import com.model.Group;

public interface GroupDao {
	public void addGroup(Group group);
	public void deleteGroup(int groupId);
	//public Group viewGroupInfo(int groupId);
	public List<Group> viewAllGroups();
}
