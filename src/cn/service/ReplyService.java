/**
 * Project Name:BBS
 * File Name:ReplyService.java
 * Package Name:cn.service
 * Date:2018年12月11日下午11:15:37
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
 */
package cn.service;

import java.util.List;
import cn.entity.Reply;


/**
 * @author zy
 *
 */
public interface ReplyService {
	public List<Reply> getAll();
	public Reply getById(int ReplyId);
	public List<Reply> getAllByPostIdAndUserId(int postId, int userId); 
	public boolean delReply(int replyId)throws Exception;
	public int addReply(Reply reply);
	public List<Reply> getAllByPostId(int postId);

}
