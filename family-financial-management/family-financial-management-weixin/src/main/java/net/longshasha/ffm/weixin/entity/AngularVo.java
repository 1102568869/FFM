package net.longshasha.ffm.weixin.entity;

import java.io.Serializable;

public class AngularVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9000357679817799416L;
	
	private String userName;
	private String userPwd;
	private String userNick;
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	

}
