package com.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Authentication implements java.io.Serializable{

	private static final long serialVersionUID = 3L;
	
	//@Id
	//@GeneratedValue
	//private int profileId;	
	
	@Id
	@Column(unique = true)
	@NotEmpty(message="userName cannot be empty")	
	private String userName;	
	@Column
	@NotEmpty(message="password cannot be empty")
	@Size(min=8,message="password must have min 8 characters")
	private String password;
	@Column
	@Email
	@NotEmpty(message="email cannot be empty")
	private String email;
	@Column
	@NotEmpty(message="contactNo cannot be empty")
	@Size(min=10,max=10,message="contactNo must be of 10 digits")
	private String contact;
	@Column
	@NotEmpty(message="firstName cannot be left blank")
	private String firstName;
	@Column
	@NotEmpty(message="lastName cannot be left blank")
	private String lastName;
	@Column
	@NotEmpty(message="address cannot be left blank")
	private String address;
	@Column
	@NotEmpty(message="gender cannot be left blank")
	private String gender;
	@Column
	@NotEmpty(message="dob cannot be left blank")
	private String dob;
	@Column
	@NotEmpty(message="education cannot be left blank")
	private String education;
	private boolean enabled=true;
	@Transient
	private MultipartFile profilePhoto;
	
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public MultipartFile getProfilePhoto() {
		return profilePhoto;
	}
	public void setProfilePhoto(MultipartFile profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	/*public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}*/
	
}
