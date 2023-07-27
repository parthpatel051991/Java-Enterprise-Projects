package in.ineuron.service;

import java.util.List;

import in.ineuron.dao.IUserDao;
import in.ineuron.factory.UserDaoFactory;
import in.ineuron.model.Blog;

public class UserServiceImpl implements IUserService {

	private IUserDao dao;
	
	
	@Override
	public boolean checkUserAuthentication(String username,String password) {
		dao=UserDaoFactory.getUserDao();
		
		return dao.checkUserAuthentication(username, password);
	}

	@Override
	public int createUser(String username,String password) {
		
		dao=UserDaoFactory.getUserDao();
		
		
		return dao.createUser(username, password);
		
		
	}

	@Override
	public int createBlog(Blog blog) {
		dao=UserDaoFactory.getUserDao();
		
		return dao.createBlog(blog);
		
		
	}

	@Override
	public List<Blog> showAllBlogs() {
		
		dao=UserDaoFactory.getUserDao();
		
		return dao.showAllBlogs();
		
		
	}

}
