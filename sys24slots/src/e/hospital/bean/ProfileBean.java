package e.hospital.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
@Entity
@Table(name="OCS_TBL_USER_PROFILE")
public class ProfileBean {
	@Id
	
	@Column(name="USERID")
	private String userID;
@Column(name="FIRSTNAME")
@NotEmpty
@Size(min=3,max = 15)
	private String firstName;
@Column(name="LASTNAME")
@NotEmpty
@Size(min=3,max = 15)
private String lastName;
@Column(name="DATEOFBIRTH")
@DateTimeFormat(iso = ISO.DATE)
@Past
@NotNull(message="Enter correct format")
private Date dateOfBirth;
@Column(name="GENDER")
private String gender;
@Column(name="STREET")
@NotEmpty
@Size(min=5,max = 20)
private String street;
@Column(name="LOCATION")
@NotEmpty
@Size(min=3,max = 15)
private String location;
@Column(name="CITY")
@NotEmpty
@Size(min=3,max = 15)
private String city;
@Column(name="STATE")
@NotEmpty
@Size(min=3,max = 15)
private String state;
@Column(name="PINCODE")
@NotEmpty
@Size(min=6,max = 6)
private String pincode;
@Column(name="MOBILENO")
@Phone
private String mobileNo;
@Column(name="EMAILID")
@NotEmpty
@Email
private String emailID;
@Transient
@NotEmpty
@Size(min=8,max = 15)
private String password;
public ProfileBean() {
	super();
}
public String getUserID() {
	return userID;
}
public void setUserID(String userID) {
	this.userID = userID;
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
public Date getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
public String getEmailID() {
	return emailID;
}

public void setEmailID(String emailID) {
	this.emailID = emailID;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
