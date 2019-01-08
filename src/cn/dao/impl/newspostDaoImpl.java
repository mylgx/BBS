package cn.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.dao.newspostDao;
import cn.entity.newspost;
import cn.entity.subject;
import cn.utils.JdbcUtils;



public class newspostDaoImpl implements newspostDao {

	@Override
	public List<newspost> getAll() {
		String sql="select * from newspost";
		return JdbcUtils.getList(newspost.class, sql);
	}
	@Override
	public newspost getBypostId(int postId) {
		String sql="select * from newspost where postId=?";
		return (newspost) JdbcUtils.getObjectById(newspost.class, sql, postId);
	}
	@Override
	public List<newspost> getBySubject(String subject) {
		String sql="select * from newspost where subject="+"\'"+subject+"\'";
		return JdbcUtils.getList(newspost.class, sql);
	}
	@Override
	public List<newspost> getByUserId(int userId) {
		String sql="select * from newspost where userId="+"\'"+userId+"\'";
		return JdbcUtils.getList(newspost.class, sql);
	}
	@Override
	public List<newspost> getByLikeTitle(String title) {
		String sql="select * from newspost where title like"+"\'%"+title+"%\'";
		return JdbcUtils.getList(newspost.class, sql);
	}
	@Override
	public int AddNewspost(newspost onepost) {
		
		String sql="insert into newspost(subject,title,message,userId,postTime) values (?,?,?,?,?)";
		return JdbcUtils.executeSQL(sql,onepost.getSubject(),onepost.getTitle(),onepost.getMessage(),onepost.getUserId(),onepost.getpostTime());
	}
	@Override
	public int DeleteNewspost(newspost onepost) {
		String sql="delete from newspost where postId= ?";
		return JdbcUtils.executeSQL(sql,onepost.getPostId());
	}
	@Override
	public int ChangeNewspost(newspost onepost) {
		String sql="update newspost set subject=?,title=?,message=?  where postId=?";
		return JdbcUtils.executeSQL(sql,onepost.getSubject(),onepost.getTitle(),onepost.getMessage(),onepost.getPostId());
	}
	@Override
	public List<subject> getAllSubject() {
		String sql="select distinct(subject) from newspost";
		return JdbcUtils.getList(subject.class, sql);
		
		
	}
}
