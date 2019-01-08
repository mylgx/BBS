package cn.dao;

import java.sql.Connection;
import java.util.List;

import cn.entity.User;


public interface UserDao {
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
	
	public boolean updateUserById(String userName,String Phone,int id);
	
}
