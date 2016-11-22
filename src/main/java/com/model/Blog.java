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
public class Blog  implements Serializable{	
	private static final long serialVersionUID = 3L;
	@Id
	@GeneratedValue
	private int blogId;	
	@NotEmpty(message="blogTitle cannot be left blank")
	private String blogTitle;
	
	@NotEmpty(message="blogContent cannot be left blank")
	private String blogContent;
	
	@NotEmpty(message="publish date cannot be left blank")
	private String publishDate;
	
	@NotEmpty(message="authorName cannot be left blank")
	private String authorName;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="BlogComments", 
          joinColumns=@JoinColumn(name="blogId"),
          inverseJoinColumns=@JoinColumn(name="commentId"))
	private List<BlogComments> comments;	
		
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogContent() {
		return blogContent;
	}
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public void setComments(List<BlogComments> blogComments){
		blogComments=new ArrayList<BlogComments>();
	}
	public List<BlogComments> getComments() {
        return comments;
    }		
	
}
