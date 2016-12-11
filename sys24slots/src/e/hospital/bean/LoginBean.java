package e.hospital.bean;

import javax.persistence.Column;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="HOSPITAL_LOGIN")
public class LoginBean 
{
@Id
@NotEmpty
@Size(min=3,max = 6)

@Column(name="USERID")
private String userID;
@Column(name="PASSWORD")
@NotEmpty
private String password;
@Column(name="USERTYPE")
private String userType;
@Column(name="LOGINSTATUS")
private int loginStatus;
public LoginBean() {
	super();
}

public LoginBean(String userID, String password, String userType,
		int loginStatus) {
	super();
	this.userID = userID;
	this.password = password;
	this.userType = userType;
	this.loginStatus = loginStatus;
}

public String getUserID() {
	return userID;
}
public void setUserID(String userID) {
	this.userID = userID;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}
public int getLoginStatus() {
	return loginStatus;
}
public void setLoginStatus(int loginStatus) {
	this.loginStatus = loginStatus;
}

@Override
public String toString() {
	return "CredentialsBean [userID=" + userID + ", password=" + password
			+ ", userType=" + userType + ", loginStatus=" + loginStatus + "]";
}

}
