package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.User;
import in.ineuron.repo.IUserRepository;

@Service("service")
public class UserServiceMgmtImpl implements IUserServiceMgmt {

	@Autowired
	private IUserRepository repo;
	
	
	@Override
	public String registerUser(User user) {
	
		User registredUser=null;
		
		if (user!=null) {
			registredUser = repo.save(user);			
		}
		
		
		return (registredUser!=null)? "User registred succesfully with id number:: "+registredUser.getId():"User registration is failed";
	}


	@Override
	public List<User> getAllUsers() {
		
		return repo.findAll();
	}

}
