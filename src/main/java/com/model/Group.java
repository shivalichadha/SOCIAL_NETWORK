package com.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Table(name = "UserGroup")
@Entity
public class Group implements java.io.Serializable{	
	private static final long serialVersionUID = 23L;
	@Id
	@GeneratedValue
	private int groupId;
	@Column
	@NotEmpty(message="Group Name cannot be left blank")
	private String groupName;
	@Column
	@NotEmpty(message="Description cannot be left blank")
	private String description;
	@Column
	@NotEmpty(message="Category cannot be left blank")
	private String category;
	@Transient
	private MultipartFile groupImage;
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public MultipartFile getGroupImage() {
		return groupImage;
	}
	public void setGroupImage(MultipartFile groupImage) {
		this.groupImage = groupImage;
	}	
	
}
