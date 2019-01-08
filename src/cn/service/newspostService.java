package cn.service;

import java.util.List;

import cn.entity.newspost;
import cn.entity.subject;

public interface newspostService {
	newspost getBypostId(int id);
	List<newspost> getAll();
	List<newspost> getBySubject(String subject);
	List<newspost> getByUserId(int userId);
	List<newspost> getByLikeTitle(String title);	
	int AddNewspost(newspost onepost);
	int DeleteNewspost(newspost onepost);
	List<subject> getAllSubject();

}
