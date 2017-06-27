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

import DButil.PublisherDbutil;
import DButil.UserDbutil;

/**
 * Servlet implementation class UserControllerServelet
 */
@WebServlet("/PublisherControllerServlet")
public class PublisherControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PublisherDbutil publisherdb;
	
	@Resource(name="jdbc/bookinventory")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			publisherdb = new PublisherDbutil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
				listPublisher(request, response);
				break;
				
			case "ADD":
				addPublisher(request, response);
				break;
				
		
			default:
				listStudents(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
		private void addPublisher(HttpServletRequest request, HttpServletResponse response) throws Exception {

			// read student info from form data
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			// create a new student object
			User user = new User(username, password);
			
			// add the student to the database
			userdb.addStudent(user);
					
			// send back to main page (the student list)
			listPublisher(request, response);
		}

		private void listPublisher(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {

			// get students from db util
			List<User> user = publisherdb.getStudents();
			
			// add students to the request
			request.setAttribute("STUDENT_LIST", user);
					
			// send to JSP page (view)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
			dispatcher.forward(request, response);
		}
	

	}
