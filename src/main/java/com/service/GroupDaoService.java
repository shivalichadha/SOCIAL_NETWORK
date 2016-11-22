package com.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.model.Group;
import com.model.dao.impl.GroupDaoImpl;

@Service
@Transactional
public class GroupDaoService {
	@Autowired
	GroupDaoImpl dao;
	public void addGroup(Group group){
		dao.addGroup(group);
	}
	/*public Group viewGroupInfo(int groupId) {
		return dao.viewGroupInfo(groupId);
		
	}*/
	public List<Group> viewAllGroups(){
		
		return dao.viewAllGroups();
	}
	public void deleteGroup(int groupId){
		dao.deleteGroup(groupId);
	}
}

