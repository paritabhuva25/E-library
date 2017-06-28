package Controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DButil.AuthorDbutil;
import pojo.Author;

/**
 * Servlet implementation class UserControllerServelet
 */
@WebServlet("/AuthorControllerServlet")
public class AuthorControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AuthorDbutil authordb;
	
	@Resource(name="jdbc/bookinventory")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			authordb = new AuthorDbutil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	doGet(request,response);
	}		
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			

			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listAuthor(request, response);
				break;
				
			case "ADD":
				addAuthor(request, response);
				break;
				
		
			default:
				listAuthor(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
		private void addAuthor(HttpServletRequest request, HttpServletResponse response) throws Exception {

			// read student info from form data
			String authorName = request.getParameter("authorname");
			String bookName = request.getParameter("authorbookname");
			
			
			// create a new publisher object
			
			Author author =new Author(authorName, bookName);
					
			System.out.println(author);
			// add the publisher to the database
			
			authordb.addAuthor(author);
			
			// send back to main page (the publisher list)
			listAuthor(request, response);
		}

		private void listAuthor(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {

			// get students from db util
			List<Author> author = authordb.getAuthor();
			
			// add students to the request
			request.setAttribute("AUTHOR_LIST", author);
					
			// send to JSP page (view)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/publisherlist.jsp");
			dispatcher.forward(request, response);
		}
	

	}