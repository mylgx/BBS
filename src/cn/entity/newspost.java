package cn.entity;


import java.text.SimpleDateFormat;
import java.util.Date;


public class newspost {
	
	private int postId;
	private String subject;
	private String title;	
	private String message;
	private int userId;
	private String postTime;
	public newspost() {
		
	}
	public newspost(String subject, String title, String message, int userId,String postTime) {
		
		this.subject = subject;
		this.title = title;
		this.message = message;
		this.userId = userId;
		this.postTime=postTime;
	}
	@Override
	public String toString() {
		return "newspost [ subject=" + subject + ", title=" + title + ", message=" + message
				+ ", userId=" + userId + ",postTime="+postTime+"]";
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getpostTime() {
		return postTime;
	}
	public void setpostTime(String postTime) {
		this.postTime=postTime;
	}
}
