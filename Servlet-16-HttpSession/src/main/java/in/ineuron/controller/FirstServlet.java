package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public FirstServlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String age = request.getParameter("age");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("username", username);
		session.setAttribute("age", age);
		
		RequestDispatcher rd = request.getRequestDispatcher("./page1.jsp");
		rd.forward(request, response);
	}

}
