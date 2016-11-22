package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Blog;
import com.model.BlogComments;
import com.model.dao.impl.BlogDaoImpl;
@Service
@Transactional
public class BlogDaoService {
	@Autowired
	BlogDaoImpl dao;
	public void addBlog(Blog blog){
		dao.addBlog(blog);		
	}
	public List<Blog> viewAllBlogs(){
		return dao.viewAllBlogs();
	}
	public Blog searchBlogByTitle(String blogTitle){
		return dao.searchBlogByTitle(blogTitle);
	}
	public void addComments(List<BlogComments>blogComments,int bid){
			dao.addComments(blogComments, bid);
	}
}

