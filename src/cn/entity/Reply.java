/**
 * Project Name:BBS
 * File Name:Reply.java
 * Package Name:bean
 * Date:2018年12月10日下午10:10:47
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
 */
package cn.entity;
import java.util.Date;

/**
 * @author zy
 *
 */
public class Reply {
	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", userId=" + userId + ", message=" + message + ", replyTime=" + replyTime
				+ ", postId=" + postId + "]";
	}

	private int replyId;
	private int userId;
	private String message;
	private String replyTime;
	private int postId;
	
	public Reply() {
		
	}
	
	public Reply(int userId,String message,String replyTime,int postId) {
		this.userId=userId;
		this.message=message;
		this.replyTime=replyTime;
		this.postId=postId;
		
	}

	/**
	 * replyId.
	 *
	 * @return  the replyId
	 * @since   JDK 1.8
	 */
	public int getReplyId() {
		return replyId;
	}

	/**
	 * replyId.
	 *
	 * @param   replyId    the replyId to set
	 * @since   JDK 1.8
	 */
	public void setReplyId(int replyId) {
		this.replyId = replyId;
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
	 * message.
	 *
	 * @return  the message
	 * @since   JDK 1.8
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * message.
	 *
	 * @param   message    the message to set
	 * @since   JDK 1.8
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * replyTime.
	 *
	 * @return  the replyTime
	 * @since   JDK 1.8
	 */
	public String getReplyTime() {
		return replyTime;
	}

	/**
	 * replyTime.
	 *
	 * @param   replyTime    the replyTime to set
	 * @since   JDK 1.8
	 */
	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}

	/**
	 * postId.
	 *
	 * @return  the postId
	 * @since   JDK 1.8
	 */
	public int getPostId() {
		return postId;
	}

	/**
	 * postId.
	 *
	 * @param   postId    the postId to set
	 * @since   JDK 1.8
	 */
	public void setPostId(int postId) {
		this.postId = postId;
	}


}
