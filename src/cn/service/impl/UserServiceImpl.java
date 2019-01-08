/**
 * Project Name:BBS
 * File Name:UserServiceImpl.java
 * Package Name:cn.service.impl
 * Date:2018年12月14日下午4:56:32
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
 */
package cn.service.impl;

import cn.entity.User;
import cn.service.UserService;
import cn.dao.UserDao;
import cn.dao.impl.UserDaoImpl;

import java.sql.Connection;
import java.util.List;

import cn.entity.User;
import cn.utils.*;


/**
 * @author zy
 *
 */
public class UserServiceImpl implements UserService {
	 private UserDao userDao;
     public UserServiceImpl() {
    	 userDao = new UserDaoImpl();
     }
	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see cn.service.UserService#getuserById(int)
	 */
	@Override
	public User getuserById(int id) {
        return userDao.getuserById(id);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see cn.service.UserService#getuserByName(java.lang.String)
	 */
	@Override
	public User getuserByName(String userName) {

		// TODO Auto-generated method stub
		return userDao.getuserByName(userName);
	}
	
	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see cn.service.UserService#getuserByWeiXin(java.lang.String)
	 */
	@Override
	
	public User getuserByWeixin(String weixin)
	{
		return userDao.getuserByWeixin(weixin);
	}
	
	@Override
	public User LoginByName(String name, String userPassword) {
		// TODO Auto-generated method stub
		Connection connection = null;
		User user = null;
		try {
			connection = JdbcUtils.getConnection();
			user = userDao.getuserByName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.close(null,null,connection);
		}
		
		if(user != null){
			if(!user.getPassword().equals(userPassword)){
				user=new User(user.getUserName(),"#","#","#");
				System.out.println("密码错误！");
			}else {
				System.out.println("登陆成功");
			}
		}
		return user;

	}
	
	@Override
	public User LoginByWeixin(String weixin,String userPassword)
	{
		Connection connection = null;
		User user = null;
		try {
			connection = JdbcUtils.getConnection();
			user = userDao.getuserByWeixin(weixin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.close(null,null,connection);
		}
		
		if(user != null){
			if(!user.getPassword().equals(userPassword)){
				user=new User(user.getWeiXin(),"#","#","#");
				System.out.println("密码错误！");
			}else {
				System.out.println("登陆成功");
			}
		}
		return user;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see cn.service.UserService#getuserIdByName(java.lang.String)
	 */
	@Override
	public int getuserIdByName(String userName) {

		// TODO Auto-generated method stub
		return userDao.getuserIdByName(userName);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see cn.service.UserService#addUser(cn.entity.User)
	 */
	@Override
	public int addUser(User user) {

		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see cn.service.UserService#delUserById(int)
	 */
	@Override
	public boolean delUserById(int id) {

		// TODO Auto-generated method stub
		return userDao.delUserById(id);
	}
	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see cn.service.UserService#updateUserById(int)
	 */
	@Override
	public boolean updateUserById(String userName,String Phone,int id) {
		return userDao.updateUserById(userName,Phone,id);
	}
	
	
	
	

}
