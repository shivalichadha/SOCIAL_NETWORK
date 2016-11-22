package com.model.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.Group;
import com.model.UserProfile;
import com.model.dao.GroupDao;

@Repository
public class GroupDaoImpl implements GroupDao{

	@Autowired
	private SessionFactory sessionFactory;	
	public void addGroup(Group group) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(group);
		session.flush();
		tx.commit();		
	}
	/*public Group viewGroupInfo(int groupId) {
		return (Group)sessionFactory.getCurrentSession().get(Group.class, groupId);
		
	}*/
	public List<Group> viewAllGroups(){
		return sessionFactory.getCurrentSession().createQuery("from Group").list(); 
	}
	public void deleteGroup(int groupId){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Group group=(Group)session.get(Group.class, new Integer(groupId));
		session.delete(group);
		session.flush();
		tx.commit();
	}	
}
