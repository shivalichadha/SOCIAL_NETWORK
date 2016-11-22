package com.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.model.Blog;
import com.model.BlogComments;

public interface BlogDao {
	public void addBlog(Blog blog);
	public List<Blog> viewAllBlogs();
	public Blog searchBlogByTitle(String blogTitle);
	public void addComments(List<BlogComments>blogComments,int blogId);
}
