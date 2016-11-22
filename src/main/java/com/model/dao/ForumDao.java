package com.model.dao;
import java.util.List;

//import java.util.List;
import com.model.Forum;

public interface ForumDao {
	public void addForum(Forum f);
	public List<Forum> viewAllForums();
	public void deleteForum(int topicId);
}
