package in.ineuron.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ineuron.factory.UserServiceFactory;
import in.ineuron.model.Blog;
import in.ineuron.service.IUserService;

@WebServlet("/controller/blog")
public class CreateBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IUserService service;
   
    public CreateBlogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String content = request.getParameter("content");
		
		Blog blog = new Blog(0, title, description, content);
		
		service=UserServiceFactory.getUserService();
		
		int rowsAffected = service.createBlog(blog);
		
		
		
		if(rowsAffected!=0) {
			
			session.setAttribute("success", true);
			
			request.getRequestDispatcher("../blog.jsp").forward(request, response);
		}else {
			session.setAttribute("failure", false);
			request.getRequestDispatcher("../blog.jsp").forward(request, response);
		}
	}

}
