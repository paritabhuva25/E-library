package Controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DButil.Bookdb;
import pojo.Book;

/**
 * Servlet implementation class BuybookControllerServlet
 */
@WebServlet("/BuybookControllerServlet")
public class BuybookControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
private Bookdb bookdb;
	
	@Resource(name="jdbc/bookinventory")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our book db util ... and pass in the conn pool / datasource
		try {
			bookdb = new Bookdb(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "SELECT";
				
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "SELECT":
				selectBook(request, response);
				break;
			
		
			default:
				selectBook(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	
	private void selectBook(HttpServletRequest request, HttpServletResponse response)throws Exception {
		// TODO Auto-generated method stub
		
		// read student id from form data
					String bookId = request.getParameter("bookId");
					System.out.println("buyyy");
					// get student from database (db util)
					Book book = bookdb.getBook(bookId);
					
					// place student in the request attribute
					request.setAttribute("THE_BOOK", book);
					
					System.out.println(book);
					// send to jsp page: update-student-form.jsp
					RequestDispatcher dispatcher = 
							request.getRequestDispatcher("/buybook.jsp");
					dispatcher.forward(request, response);
		
	}


	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
