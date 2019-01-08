package cn.service.impl;

import java.util.List;

import cn.dao.newspostDao;
import cn.dao.impl.newspostDaoImpl;
import cn.entity.newspost;
import cn.entity.subject;
import cn.service.newspostService;

public class newspostServiceImpl implements newspostService {
	private newspostDao ndao=new newspostDaoImpl();

	@Override
	public List<newspost> getAll() {
		
		return ndao.getAll();
	}

	@Override
	public List<newspost> getBySubject(String subject) {
		
		return ndao.getBySubject(subject);
	}

	@Override
	public List<newspost> getByUserId(int userId) {
		
		return ndao.getByUserId(userId);
	}

	@Override
	public List<newspost> getByLikeTitle(String title) {
		
		return ndao.getByLikeTitle(title);
	}

	@Override
	public newspost getBypostId(int postId) {
		
		return ndao.getBypostId(postId);
	}

	@Override
	public int AddNewspost(newspost onepost) {
		int flag=0;
		int addn=ndao.AddNewspost(onepost);
		if(addn>0) {
			flag=1;
			System.out.println("添加成功");
		}
		else {
			System.out.println("添加失败");
		}
		return flag;
	}

	@Override
	public int DeleteNewspost(newspost onepost) {
		return ndao.DeleteNewspost(onepost);
	}

	@Override
	public List<subject> getAllSubject() {
		
		return ndao.getAllSubject();
	}
	
	
	public static void main(String[] args) {
		newspostService bdi = new newspostServiceImpl();
		System.out.println(bdi.getAllSubject());
	
	}

}
