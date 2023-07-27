package in.ineuron.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/create")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CreateAccountServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("phone", phone);
		session.setAttribute("email", email);
		session.setAttribute("password", password);
		
		
		request.getRequestDispatcher("./page2.jsp").forward(request, response);
		
	}

}
