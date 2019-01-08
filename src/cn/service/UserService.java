/**
 * Project Name:BBS
 * File Name:UserService.java
 * Package Name:cn.service
 * Date:2018年12月14日下午4:54:30
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
 */
package cn.service;
import java.sql.Connection;
import java.util.List;

import cn.entity.User;

/**
 * @author zy
 *
 */
public interface UserService {
	//通过用户编号获得用户
		public User getuserById(int id);
		//通过用户名获得用户
		public User getuserByName(String userName);
		//通过用户名获得用户编号
		public int getuserIdByName(String userName);
		//通过微信获取用户
		public User getuserByWeixin(String weixin);
		//增加用户
		public int addUser(User user);
		//删除用户
		public boolean delUserById(int id);
		//更新用户
		public boolean updateUserById(String userName,String Phone,int id);
		User LoginByName(String name, String userPassword);
		User LoginByWeixin(String weixin,String userPassword);
}
