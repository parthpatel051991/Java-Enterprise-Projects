package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.factory.StudentServiceFactory;
import in.ineuron.model.Student;
import in.ineuron.service.IStudentService;

@WebServlet("/controller/*")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IStudentService service;

	public StudentServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {

		if (request.getRequestURI().endsWith("test")) {

			System.out.println("StudentServlet.doProcess()");

			service = StudentServiceFactory.getStudentService();

			List<Student> detailsOfAllStudents = service.detailsOfAllStudents();

			response.setContentType("text/html");

			try {

				PrintWriter out = response.getWriter();

				// Create the HTML table
				out.println("<html><body><table border='1'>");

				// Print table headers
				out.println("<tr>");
				out.println("<th>sid</th>");
				out.println("<th>sname</th>");
				out.println("<th>sage</th>");
				out.println("<th>saddress</th>");
				// Add more headers as needed for your table

				out.println("</tr>");

				// Print table rows
				for (Student student : detailsOfAllStudents) {
					out.println("<tr>");
					out.println("<td>" + student.getSid() + "</td>");
					out.println("<td>" + student.getSname() + "</td>");
					out.println("<td>" + student.getSage() + "</td>");
					out.println("<td>" + student.getSaddress() + "</td>");
					// Add more columns as needed for your table

					out.println("</tr>");
				}

				out.println("</table></body></html>");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
