package com.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.Blog;
import com.model.BlogComments;
import com.model.dao.BlogDao;

@Repository
public class BlogDaoImpl implements BlogDao {
	@Autowired
	SessionFactory sessionFactory;
	public void addBlog(Blog blog){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(blog);
		session.flush();
		tx.commit();		
	}
	public List<Blog> viewAllBlogs(){
		return sessionFactory.getCurrentSession().createQuery("from Blog").list();		
	}
	public Blog searchBlogByTitle(String blogTitle){
		return (Blog)sessionFactory.getCurrentSession().get(Blog.class,blogTitle);		
	}	
	public void addComments(List<BlogComments>blogComments,int blogId){
		Session session=sessionFactory.getCurrentSession();
		Blog blog=(Blog)session.get(Blog.class, blogId);
		BlogComments bgComments=new BlogComments();		
		session.save(bgComments);
		blog.setComments(blogComments);
		
	}
	
}
