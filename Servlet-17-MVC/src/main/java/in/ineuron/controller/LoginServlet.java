package in.ineuron.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ineuron.factory.UserServiceFactory;
import in.ineuron.service.IUserService;


@WebServlet("/controller/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private IUserService service;
	
    public LoginServlet() {
        super();
        
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		service=UserServiceFactory.getUserService();
		
		boolean userAuthentication = service.checkUserAuthentication(username, password);
		
		System.out.println(userAuthentication);
		
		
		
		
		if (userAuthentication) {
			request.getRequestDispatcher("../blog.jsp").forward(request, response);
		}else {
			
			session.setAttribute("authentication", false);
			request.getRequestDispatcher("../index.jsp").forward(request, response);
			
		}
		
	}

}
