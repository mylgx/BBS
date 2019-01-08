/**
 * Project Name:BBS
 * File Name:User.java
 * Package Name:bean
 * Date:2018��12��10������10:15:47
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
 */
package cn.entity;

/**
 * @author zy
 *
 */
public class User {
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", phoneNumber="
				+ phoneNumber + ", weiXin=" + weiXin + "]";
	}

	private int userId;
	private String userName;
	private String password;
	private String  phoneNumber;
	private String weiXin;
	
	
	public User() {
	}

	public User( String userName, String password, String phoneNumber, String weiXin) {
		super();
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.weiXin = weiXin;
		
	}

	/**
	 * userId.
	 *
	 * @return  the userId
	 * @since   JDK 1.8
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * userId.
	 *
	 * @param   userId    the userId to set
	 * @since   JDK 1.8
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * userName.
	 *
	 * @return  the userName
	 * @since   JDK 1.8
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * userName.
	 *
	 * @param   userName    the userName to set
	 * @since   JDK 1.8
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * password.
	 *
	 * @return  the password
	 * @since   JDK 1.8
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * password.
	 *
	 * @param   password    the password to set
	 * @since   JDK 1.8
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * phoneNumber.
	 *
	 * @return  the phoneNumber
	 * @since   JDK 1.8
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * phoneNumber.
	 *
	 * @param   phoneNumber    the phoneNumber to set
	 * @since   JDK 1.8
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * weiXin.
	 *
	 * @return  the weiXin
	 * @since   JDK 1.8
	 */
	public String getWeiXin() {
		return weiXin;
	}

	/**
	 * weiXin.
	 *
	 * @param   weiXin    the weiXin to set
	 * @since   JDK 1.8
	 */
	public void setWeiXin(String weiXin) {
		this.weiXin = weiXin;
	}

	/**
	 * userId.
	 *
	 * @return  the userId
	 * @since   JDK 1.8
	 */

	
	

}
