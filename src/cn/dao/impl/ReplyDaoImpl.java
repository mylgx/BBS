/**
 * Project Name:BBS
 * File Name:ReplyDaoImpl.java
 * Package Name:cn.dao.impl
 * Date:2018年12月11日下午11:21:37
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
 */
package cn.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import cn.dao.ReplyDao;
import cn.entity.Reply;
import cn.entity.User;
import cn.entity.newspost;
import cn.utils.JdbcUtils;

/**
 * @author zy
 *
 */
public class ReplyDaoImpl implements ReplyDao {

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see cn.dao.ReplyDao#getAll()
	 */
	@Override
	public List<Reply> getAll() {
		String sql="select * from reply";
		return JdbcUtils.getList(Reply.class, sql);
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see cn.dao.ReplyDao#getById(int)
	 */
	@Override
	public Reply getById(int replyId) {

		// TODO Auto-generated method stub
	    String sql="select * from reply where replyId=?";
	    return (Reply)JdbcUtils.getObjectById(Reply.class, sql, replyId);
	}
	
	public int addReply(Reply reply) {
		int n=0;
		String sql="insert into reply(userId,message,replyTime,postId)values(?,?,?,?)";
		n=JdbcUtils.executeSQL(sql, reply.getUserId(),reply.getMessage(),reply.getReplyTime(),reply.getPostId());
		return n;
	}
	
	public boolean delReply(int id) {
		String sql="delete from reply where replyId=?";
		int m=JdbcUtils.executeSQL(sql, id);
		if(m>0)
			return true;
		else
			return false;
		
	}

	@Override
	public List<Reply> getAllByPostId(int postId) {
		String sql="select * from reply where postId="+"\'"+postId+"\'";
		return JdbcUtils.getList(Reply.class, sql);
	}

	@Override
	public List<Reply> getAllByPostIdAndUserId(int postId, int userId) {
		String sql="select * from reply where postId="+"\'"+postId+"\'"+"and userId="+"\'"+userId+"\'";
		return JdbcUtils.getList(Reply.class, sql);
	}
}
