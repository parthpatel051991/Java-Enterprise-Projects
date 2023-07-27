package in.ineuron.service;

import java.util.List;

import in.ineuron.model.User;

public interface IUserServiceMgmt {

	public String registerUser(User user);
	
	public List<User> getAllUsers();
}
