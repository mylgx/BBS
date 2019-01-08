/**
 * Project Name:BBS
 * File Name:UserDaoImpl.java
 * Package Name:cn.dao.impl
 * Date:2018年12月14日下午4:34:54
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
 */
package cn.dao.impl;

import cn.dao.UserDao;
import cn.entity.User;

import java.sql.SQLException;
import java.util.List;
import cn.utils.JdbcUtils;

/**
 * @author zy
 *
 */
public class UserDaoImpl implements UserDao {

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see cn.dao.UserDao#getuserById(int)
	 */
	/*@Override
	public User getuserById(String id) {
		String sql = "select * from user where userId=?";
		return (User) JdbcUtils.getObjectById(User.class, sql, id);
	}*/

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see cn.dao.UserDao#getuserByName(java.lang.String)
	 */
	@Override
	public User getuserByName(String userName) {
		String sql = "select * from user where userName=?";
		User user = new User();
	    user =(User)JdbcUtils.getObjectById(User.class, sql, userName);
	    return user;
	}

	public User getuserById(int userId) {
		String sql="select * from user where userId=?";
		return (User) JdbcUtils.getObjectById(User.class, sql, userId);

	}

	
	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see cn.dao.UserDao#getuserIdByName(java.lang.String)
	 */
	@Override
	public int getuserIdByName(String userName) {
		String sql = "select userId from user where userName=?";
	    return (int) JdbcUtils.getObjectById(User.class, sql, userName);
	}
	
	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see cn.dao.UserDao#getuserByWeixin(cn.entity.User)
	 */
	@Override
	public User getuserByWeixin(String weixin)
	{
		String sql="select * from user where weixin=?";
		return (User) JdbcUtils.getObjectById(User.class, sql, weixin);

	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see cn.dao.UserDao#addUser(cn.entity.User)
	 */
	@Override
	public int addUser(User user) {
		String sql = "insert into user(userName,password,phoneNumber,weiXin)values(?,?,?,?)";
		return JdbcUtils.executeSQL(sql,user.getUserName(),user.getPassword(),user.getPhoneNumber(),user.getWeiXin());
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see cn.dao.UserDao#delUserById(int)
	 */
	@Override
	public boolean delUserById(int id) {

		String sql = "delete from user where userId=?";
		int m=JdbcUtils.executeSQL(sql, id);
		if(m!=0)
			return true;
		else
			return false;
	}
	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see cn.dao.UserDao#updateUserById(int)
	 */
	@Override
	public boolean updateUserById(String userName,String Phone,int id) {
		String sql="update user set userName=?,phoneNumber=? where userId=?";
		int n=JdbcUtils.executeSQL(sql,userName,Phone,id);
		if(n!=0)
			return true;
		else
			return false;
	}
	
	

}
