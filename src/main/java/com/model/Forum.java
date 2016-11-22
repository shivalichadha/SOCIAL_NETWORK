package com.model;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.JoinColumn;
@Entity
public class Forum  implements Serializable{	
	private static final long serialVersionUID = 3L;
	@Id
	@GeneratedValue
	private int topicId;	
	@NotEmpty(message="topic cannot be left blank")
	private String topic;
	
	@NotEmpty(message="post cannot be left blank")
	private String post;
	
	@NotEmpty(message="post date cannot be left blank")
	private String postDate;
	
	@NotEmpty(message="Name cannot be left blank")
	private String postBy;
		
	//@NotEmpty(message="Name cannot be left blank")
	//private String owner;
	
	
	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getPostBy() {
		return postBy;
	}

	public void setPostBy(String postBy) {
		this.postBy = postBy;
	}

	/*public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}*/

		
	

}
