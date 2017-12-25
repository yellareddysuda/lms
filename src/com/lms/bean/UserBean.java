package com.lms.bean;

public class UserBean {

	private String userId;
	private String userName;
	private String password;
	private UserType userType;
	private boolean active;
	private UserDetailsBean userDetails;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public UserDetailsBean getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetailsBean userDetails) {
		this.userDetails = userDetails;
	}

}
