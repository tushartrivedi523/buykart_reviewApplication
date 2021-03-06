package com.nagarro.backendApp.reviewApp.model;

import javax.persistence.*;

@Entity
@Table(name="userauth")
public class UserAuth {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userid")
	long userid;
	@Column(name="username")
	String userName;
	@Column(name="userpassword")
	String userPassword;
	@Column(name="userfirstname")
	String userFirstName;
	@Column(name="userlastname")
	String userLastName;
	@Column(name="useremail")
	String userEmail;
	
	
	
	public UserAuth(String userName, String userPassword, String userFirstName, String userLastName,
			String userEmail) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public UserAuth() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserAuth(String userName, String userPassword, String userFirstName, String userLastName) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
	}
	
	public long getUserId() {
		return userid;
	}
	public void setUserId(int userId) {
		this.userid = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	@Override
	public String toString() {
		return "UserAuth [userId=" + userid + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + "]";
	}
	
	
	
}
