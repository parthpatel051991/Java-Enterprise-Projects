package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.User;
import in.ineuron.repo.IUserRepository;
import lombok.NonNull;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository repo;

	@Override
	public Integer registerUser(User user) {

		User existed_user = repo.findByEmail(user.getEmail());
		
		User registredUser = null;

		if (user != null && existed_user==null) {
			registredUser = repo.save(user);
		}

		return (registredUser != null) ? registredUser.getUserId()
				: 0;
	}

	@Override
	public Boolean authenticateUser(String email,String password) {
		
		User existed_User = repo.findByEmail(email);
		
		if (existed_User!=null) {
			String original_password = existed_User.getPassword();
			
			if(password.equals(original_password)) {
				return true;
			}
		}
			
		return false;
		
	}
}
