package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Blog;

public interface IUserService {

	public boolean checkUserAuthentication(String username,String password);

	public int createUser(String username,String password);

	public int createBlog(Blog blog);

	public List<Blog> showAllBlogs();
}
