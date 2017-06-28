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



import DButil.Bookdb;
import DButil.UserDbutil;

/**
 * Servlet implementation class BookControllerServelet
 */
@WebServlet("/BookControllerServlet")
public class BookControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Bookdb bookdb;
	
	@Resource(name="jdbc/bookinventory")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			bookdb = new Bookdb(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
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
				listBook(request, response);
				break;
				
			case "ADD":
				addBook(request, response);
				break;
				
			case "LOAD":
				loadBook(request, response);
				break;
				
			case "UPDATE":
				updateBook(request, response);
				break;
			
			case "DELETE":
				deleteBook(request, response);
				break;
		
			default:
				listBook(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	private void deleteBook(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			// read student id from form data
			String bookId = request.getParameter("bookId");
			
			// delete student from database
			bookdb.deleteBook(bookId);
			
			// send them back to "list students" page
			listBook(request, response);
		}

		private void updateBook(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			// read student info from form data
			int bookId = Integer.parseInt(request.getParameter("BookId"));
	String bookTitle = request.getParameter("booktitle");
			
			String isbnNo1 = request.getParameter("isbnnumber");
			int isbnNo = Integer.parseInt(isbnNo1);

			String price1 = request.getParameter("price");
			int price =  Integer.parseInt(price1);
			
			String authorId1 = request.getParameter("authorId");
			int authorId =  Integer.parseInt(authorId1);
			
			String publisherId1 = request.getParameter("publisherId");
			int publisherId = Integer.parseInt(publisherId1);

			int studentId = 1;
			
			String quantity1 = request.getParameter("totlaquantity");
			int quantity = Integer.parseInt(quantity1);

			String soldquantity1 = request.getParameter("soldquantity");
			int soldquantity = Integer.parseInt(soldquantity1);

			String publicationDate1 = request.getParameter("publicationDate");
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date publicationDate = format.parse(publicationDate1);
			
			String purchaseDate1 = request.getParameter("purchaseDate");
			Date purchaseDate = format.parse(purchaseDate1);
			
			// create a new student object
			Book book = new Book(bookId, bookTitle, isbnNo, price, authorId, publisherId, studentId, quantity, soldquantity, publicationDate, purchaseDate);
			
			// perform update on database
			bookdb.updateBook(book);
			
			// send them back to the "list students" page
			listBook(request, response);
			
		}

		private void loadBook(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {

			// read student id from form data
			String bookId = request.getParameter("studentId");
			
			// get student from database (db util)
			Book book = bookdb.getBook(bookId);
			
			// place student in the request attribute
			request.setAttribute("THE_BOOK", book);
			
			// send to jsp page: update-student-form.jsp
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/update-student-form.jsp");
			dispatcher.forward(request, response);		
		}

		private void addBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			
			// read student info from form data
			String bookTitle = request.getParameter("booktitle");
			
			String isbnNo1 = request.getParameter("isbnnumber");
			int isbnNo = Integer.parseInt(isbnNo1);

			String price1 = request.getParameter("price");
			int price =  Integer.parseInt(price1);
			
			String authorId1 = request.getParameter("authorId");
			int authorId =  Integer.parseInt(authorId1);
			
			String publisherId1 = request.getParameter("publisherId");
			int publisherId = Integer.parseInt(publisherId1);

			int studentId = 1;
			
			String quantity1 = request.getParameter("totlaquantity");
			int quantity = Integer.parseInt(quantity1);

			String soldquantity1 = request.getParameter("soldquantity");
			int soldquantity = Integer.parseInt(soldquantity1);

			String publicationDate1 = request.getParameter("publicationDate");
			DateFormat format = new SimpleDateFormat("MM-DD-YYYY");
			Date publicationDate = format.parse(publicationDate1);
			
			String purchaseDate1 = request.getParameter("purchaseDate");
			Date purchaseDate = format.parse(purchaseDate1);
			
			// create a new student object
			Book book = new Book(bookTitle, isbnNo, price, authorId, publisherId, studentId, quantity, soldquantity, publicationDate, purchaseDate);
			// add the student to the database
			bookdb.addBook(book);
					
			// send back to main page (the student list)
			//listStudents(request, response);
		}

		private void listBook(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
			
			System.out.println("callll");

			// get students from db util
			List<Book> book = bookdb.getBook();
			
			System.out.println(book);
			
			// add students to the request
			request.setAttribute("BOOK_LIST", book);
			
			// send to JSP page (view)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/homepage.jsp");
			dispatcher.forward(request, response);
		}
	
	}


