package com.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class UserProfile implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private String profileId;
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
	@NotEmpty(message="contact cannot be left blank")
	@Size(min=10,max=10,message="contactNo must be of 10 digits")
	private String contact;
	@Column
	@NotEmpty(message="email cannot be left blank")
	private String email;
	@Column
	@NotEmpty(message="gender cannot be left blank")
	private String gender;
	@Column
	@NotEmpty(message="dob cannot be left blank")
	private String dob;
	@Column
	@NotEmpty(message="education cannot be left blank")
	private String education;	
	@Transient
	private MultipartFile profilePhoto;
	
	
	
	public String getProfileId() {
		return profileId;
	}
	public void setProfileId(String profileId) {
		this.profileId = profileId;
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
}
