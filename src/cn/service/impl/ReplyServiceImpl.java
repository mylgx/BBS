/**
 * Project Name:BBS
 * File Name:ReplyServiceImpl.java
 * Package Name:cn.service.impl
 * Date:2018年12月12日上午12:04:22
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
 */
package cn.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.dao.ReplyDao;
import cn.dao.impl.ReplyDaoImpl;
import cn.entity.Reply;
import cn.service.ReplyService;

/**
 * @author zy
 *
 */
public class ReplyServiceImpl implements ReplyService {
	private ReplyDao replyDao=new ReplyDaoImpl();
	

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see cn.service.ReplyService#getAll()
	 */
	@Override
	public List<Reply> getAll() {
		return replyDao.getAll();
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see cn.service.ReplyService#getById(int)
	 */
	@Override
	public Reply getById(int ReplyId) {
		
		return replyDao.getById(ReplyId);
	}
	
	public int addReply(Reply reply) {
		int flag=0;
			int add=replyDao.addReply(reply);
			if(add>0) {
				flag=1;
				System.out.println("添加成功");
			}
			else {
				System.out.println("添加失败");
			}
		return flag;
	}
	
	public boolean delReply(int id) {
		return replyDao.delReply(id);
	}

	@Override
	public List<Reply> getAllByPostId(int postId) {
		return replyDao.getAllByPostId(postId);
	}

	@Override
	public List<Reply> getAllByPostIdAndUserId(int postId, int userId) {
		return replyDao.getAllByPostIdAndUserId(postId, userId);
	}

}
