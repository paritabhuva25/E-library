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
import pojo.Publisher;

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
				listPublisher(request, response);
				break;
				
			case "ADD":
				addPublisher(request, response);
				break;
				
		
			default:
				listPublisher(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
		private void addPublisher(HttpServletRequest request, HttpServletResponse response) throws Exception {

			// read student info from form data
			String publisherName = request.getParameter("publishername");
			String publisherCountry = request.getParameter("publishercountry");
			String contactNumber1 = request.getParameter("publishermobilenumber");
			int contactNumber = Integer.parseInt(contactNumber1);
			String bookName = request.getParameter("publisherbookname");
			
			
			// create a new publisher object
			
			Publisher publisher =new Publisher(publisherName, publisherCountry, contactNumber, bookName);
					
			System.out.println(publisher);
			// add the publisher to the database
			
			publisherdb.addPublisher(publisher);
			
			// send back to main page (the publisher list)
			listPublisher(request, response);
		}

		private void listPublisher(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {

			// get students from db util
			List<Publisher> publisher = publisherdb.getPublisher();
			
			// add students to the request
			request.setAttribute("PUBLISHER_LIST", publisher);
					
			// send to JSP page (view)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/publisherlist.jsp");
			dispatcher.forward(request, response);
		}
	

	}
