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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import DButil.UserDbutil;
import pojo.User;


/**
 * Servlet implementation class UserControllerServelet
 */
@WebServlet("/UserControllerServelet")
public class UserControllerServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDbutil userdb;
	
	@Resource(name="jdbc/bookinventory")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			userdb = new UserDbutil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
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
				listStudents(request, response);
				break;
				
			case "ADD":
				addStudent(request, response);
				break;
				
		
			default:
				listStudents(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
		private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

			// read student info from form data
			String username = request.getParameter("regusername");
			String password = request.getParameter("regpassword");
			String mobilenumber1 = request.getParameter("regmobno");
			int mobilenumber = Integer.parseInt(mobilenumber1);
			// create a new student object
			User user = new User(username, password ,mobilenumber);
			
			// add the student to the database
			userdb.addStudent(user);
					
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Register.jsp");
			dispatcher.forward(request, response);
		
		}

		private void listStudents(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {

			// get students from db util
			List<User> user = userdb.getStudents();
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			int flag =0;
			
			for (int i = 0; i < user.size(); i++) {
				
				if(user.get(i).getPassword().equals(password) && user.get(i).getUsername().equals(username)){
					
					 HttpSession session=request.getSession();  
				        session.setAttribute("uname",username);  
					flag =1;
					break;
				}
				
				flag = 0;
			}
			
			if(flag == 1){
				
				request.setAttribute("STUDENT_LIST", user);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/homepage.jsp");
				dispatcher.forward(request, response);
				
			}else{
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Register.jsp");
				dispatcher.forward(request, response);
			}
			
			
			// add students to the request
			
					
			// send to JSP page (view)
		
		}
	

	}


