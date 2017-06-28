package Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import DButil.StudentDbutil;
import pojo.Student;

/**
 * Servlet implementation class StudentControllerServelet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StudentDbutil studentdb;
	
	@Resource(name="jdbc/bookinventory")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			studentdb = new StudentDbutil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		System.out.println("callllll");
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			System.out.println(theCommand);
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listStudent(request, response);
				break;
				
			case "ADD":
				addStudent(request, response);
				break;
				
		
			default:
				listStudent(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
		private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

			// read student info from form data
			String studentName = request.getParameter("studentname");
			
			String studentIssuedate1 = request.getParameter("issuedate");
			DateFormat format = new SimpleDateFormat("mm/dd/yyyy");
			Date  studentIssuedate = format.parse(studentIssuedate1);
			
			String studentbookName = request.getParameter("studentbookname");
			
			// create a new publisher object
			
			Student student =new Student(studentName, studentIssuedate, studentbookName);
					
			System.out.println(student);
			// add the publisher to the database
			
			studentdb.addStudent(student);
			
			// send back to main page (the publisher list)
			listStudent(request, response);
		}

		private void listStudent(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {

			// get students from db util
			List<Student> student = studentdb.getStudent();
			
			// add students to the request
			request.setAttribute("STUDENT_LIST", student);
					
			// send to JSP page (view)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/publisherlist.jsp");
			dispatcher.forward(request, response);
		}
	

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
