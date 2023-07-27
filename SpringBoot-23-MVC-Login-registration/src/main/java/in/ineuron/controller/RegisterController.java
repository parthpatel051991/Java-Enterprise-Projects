package in.ineuron.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.model.User;
import in.ineuron.service.IUserService;

@Controller
public class RegisterController {

	@Autowired
	private IUserService service;
	
	@GetMapping("/reg")
	public String showRegistrationForm() {
		
		return "registration";
	}
	
	
	
	
	@PostMapping("/register")
	public String registerUser(Map<String, Object> model,@RequestParam String email,@RequestParam String password,@RequestParam String name,@RequestParam Integer age) {
		
	
		if (email.isEmpty() || password.isEmpty()) {
			model.put("msg", "Please enter your details");
			return "registration";
			
		}else {
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			user.setName(name);
			user.setAge(age);
			
			Integer rowsAffected = service.registerUser(user);
			System.out.println(rowsAffected);
			
			if(rowsAffected==0) {
				model.put("msg", "User name is not available");
				return "registration";
			}else {
				model.put("msg", "User Registered Succesfully");
				return "login";
				
			}
		}
		
		
	
	}
}
