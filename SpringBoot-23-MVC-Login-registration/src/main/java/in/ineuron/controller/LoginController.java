package in.ineuron.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.model.User;
import in.ineuron.service.IUserService;

@Controller
public class LoginController {

	@Autowired
	private IUserService service;

	@GetMapping(value = "/")
	public String showHome() {
		return "login";
	}

	@PostMapping("/login")
	public String checkAuthentication(Map<String, Object> model,HttpServletRequest request, @RequestParam String email,
			@RequestParam String password) {

		if (email.isEmpty() || password.isEmpty()) {
			model.put("msg", "Please enter your details");
			return "login";

		} else {

			User user = new User();
			user.setEmail(email);
			user.setPassword(password);

			HttpSession session = request.getSession();
			
			boolean result = service.authenticateUser(email, password);
			System.out.println(result);
			if (result) {
				
				session.setAttribute("username", email);
				model.put("msg", "login is successfull");
				return "home";
			} else {

				model.put("msg", "Invalid username or password.");
				return "login";
			}
		}

	}
}
