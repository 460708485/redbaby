package com.redbaby.domain;

/**
 * 登录User信息 
 *
 */
public class LoginUserInfo {
	private int userId;
	private String usersession;

	public LoginUserInfo() {
	}

	public LoginUserInfo(int userId, String usersession) {
		super();
		this.userId = userId;
		this.usersession = usersession;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsersession() {
		return usersession;
	}

	public void setUsersession(String usersession) {
		this.usersession = usersession;
	}

}
