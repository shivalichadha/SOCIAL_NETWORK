package com.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.model.Forum;
import com.model.dao.impl.ForumDaoImpl;

@Service
@Transactional
public class ForumService {	
	
	@Autowired
	ForumDaoImpl dao;
	public void addForum(Forum f){
		dao.addForum(f);
		
	}
	public List<Forum> viewAllForums(){
		return dao.viewAllForums();
	}
	public void deleteForum(int topicId){
		dao.deleteForum(topicId);
	}
}
