package in.ineuron.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ineuron.factory.UserServiceFactory;
import in.ineuron.service.IUserService;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private IUserService service;
   
    public RegisterServlet() {
        super();
      
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		service=UserServiceFactory.getUserService();
		
		int rowAffected = service.createUser(username,password);
		

		if(rowAffected==1) {
			
			session.setAttribute("result", "Account created Succesfully");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if(rowAffected==-1) {
			session.setAttribute("result", -1);
			request.getRequestDispatcher("./register.jsp").forward(request, response);	
		}else if(rowAffected==0) {
			session.setAttribute("result", 0);
			request.getRequestDispatcher("./register.jsp").forward(request, response);
		}
	}

}
