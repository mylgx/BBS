/**
 * Project Name:BBS
 * File Name:ReplyDao.java
 * Package Name:cn.dao
 * Date:2018年12月11日下午11:03:17
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
 */
package cn.dao;
import java.sql.SQLException;
import java.util.List;
import cn.entity.Reply;

/**
 * @author zy
 *
 */
public interface ReplyDao {
	/**
	 * 查询所有信息
	 *@return 所有回帖
	 */
	
	public List<Reply> getAll();
	public List<Reply> getAllByPostId(int postId);
	public List<Reply> getAllByPostIdAndUserId(int postId,int userId);
	/**
	 * 根据回帖编号，查询唯一一个课程
	 *@param replyId要查询的回帖编号
	 *@return 根据编号查出的帖子对象
	 */
	public Reply getById(int replyId);
	/**
	 * @param Reply要增加的业务对象
	 *@return 影响的行数
	 */
	public int addReply(Reply reply);
	/**
	 * @param Reply要删除的业务对象
	 *@return 是否删除成功
	 */
    public boolean delReply(int id);
	
	
	
	

}
