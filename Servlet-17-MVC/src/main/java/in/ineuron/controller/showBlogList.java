package in.ineuron.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.factory.UserServiceFactory;
import in.ineuron.model.Blog;
import in.ineuron.service.IUserService;

@WebServlet("/controller/show")
public class showBlogList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IUserService service;
   
    public showBlogList() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		service=UserServiceFactory.getUserService();
		
		List<Blog> blogPosts = service.showAllBlogs();

	    request.setAttribute("blogPosts", blogPosts);

	    RequestDispatcher dispatcher = request.getRequestDispatcher("../BlogList.jsp");
	    dispatcher.forward(request, response);
	}

}
