package cn.dao;

import java.util.List;

import cn.entity.newspost;
import cn.entity.subject;

public interface newspostDao {
	List<newspost> getAll();
	List<newspost> getBySubject(String subject);
	List<newspost> getByUserId(int userId);
	List<newspost> getByLikeTitle(String title);
	newspost getBypostId(int postId);
	int AddNewspost(newspost onepost);
	int DeleteNewspost(newspost onepost);
	int ChangeNewspost(newspost onepost);
	List<subject> getAllSubject();

}
