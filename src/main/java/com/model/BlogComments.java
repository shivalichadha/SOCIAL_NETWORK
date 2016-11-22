package com.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class BlogComments implements java.io.Serializable{
	private static final long serialVersionUID = 6L;
	@Id
	@GeneratedValue
	private int commentId;
	private String comment;	
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}	
}
