package DButil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;



import Controller.Book;
import Controller.User;

public class Bookdb {
	
	
	private DataSource dataSource;

	public Bookdb(DataSource theDataSource) {
		dataSource = theDataSource;
	}
public List<Book> getBook() throws Exception {
	
	
		
		List<Book> book = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from book";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			System.out.println(myRs);
			// process result set
			while (myRs.next()) {
				
				String bookId1 = myRs.getString("book_id");
				int bookId = Integer.parseInt(bookId1);
				
				String bookTitle = myRs.getString("book_title");
				
				String isbnNo1 = myRs.getString("book_isbn");
				int isbnNo = Integer.parseInt(isbnNo1);
				
				String price1 = myRs.getString("book_price");
				int price =  Integer.parseInt(price1);
				
				String authorId1 = myRs.getString("book_author_id");
				int authorId =  Integer.parseInt(authorId1);
				
				String publisherId1 = myRs.getString("book_publisher_id");
				int publisherId = Integer.parseInt(publisherId1);
				
				String studentId1 = myRs.getString("book_student_issueid");
				int studentId = Integer.parseInt(studentId1);
				
				String quantity1 = myRs.getString("book_totalquantity");
				int quantity = Integer.parseInt(quantity1);
				
				String soldquantity1 = myRs.getString("book_soldquantity");
				int soldquantity = Integer.parseInt(soldquantity1);

				Date publicationDate = myRs.getDate("book_publicationyear");
				
				
				Date purchaseDate = myRs.getDate("book_purchasedate");
			
				// create new student object
				Book bookdetail = new Book(bookId, bookTitle, isbnNo, price, authorId, publisherId, studentId, quantity, soldquantity, publicationDate, purchaseDate);
				
				// add it to the list of students
				book.add(bookdetail);				
			}
			
			return book;		
		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}	
	}
private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

	try {
		if (myRs != null) {
			myRs.close();
		}
		
		if (myStmt != null) {
			myStmt.close();
		}
		
		if (myConn != null) {
			myConn.close();   // doesn't really close it ... just puts back in connection pool
		}
	}
	catch (Exception exc) {
		exc.printStackTrace();
	}
}
public Book getBook(String bookId) throws Exception {

	Book book = null;
	
	Connection myConn = null;
	PreparedStatement myStmt = null;
	ResultSet myRs = null;
	int bookid;
	
	try {
		// convert student id to int
		bookid = Integer.parseInt(bookId);
		
		// get connection to database
		myConn = dataSource.getConnection();
		
		// create sql to get selected student
		String sql = "select * from book where book_id = ?";
		
		// create prepared statement
		myStmt = myConn.prepareStatement(sql);
		
		// set params
		myStmt.setInt(1, bookid);
		
		// execute statement
		myRs = myStmt.executeQuery();
		
		// retrieve data from result set row
		if (myRs.next()) {

			String bookTitle = myRs.getString("booktitle");
			
			String isbnNo1 = myRs.getString("isbnno");
			int isbnNo = Integer.parseInt(isbnNo1);
			
			String price1 = myRs.getString("price");
			int price =  Integer.parseInt(price1);
			
			String authorId1 = myRs.getString("authorId1");
			int authorId =  Integer.parseInt(authorId1);
			
			String publisherId1 = myRs.getString("publisherId");
			int publisherId = Integer.parseInt(publisherId1);
			
			String studentId1 = myRs.getString("studentId");
			int studentId = Integer.parseInt(studentId1);
			
			String quantity1 = myRs.getString("quantity");
			int quantity = Integer.parseInt(quantity1);
			
			String soldquantity1 = myRs.getString("soldquantity");
			int soldquantity = Integer.parseInt(soldquantity1);

			Date publicationDate = myRs.getDate("publicationDate");
			
			
			Date purchaseDate = myRs.getDate("purchaseDate");
		
			// create new student object
			Book bookdetail = new Book(bookid ,bookTitle, isbnNo, price, authorId, publisherId, studentId, quantity, soldquantity, publicationDate, purchaseDate);
			
			
		}
		else {
			throw new Exception("Could not find book id: " + bookId);
		}		
		
		System.out.println(book);
		
		return book;
	}
	finally {
		// clean up JDBC objects
		close(myConn, myStmt, myRs);
	}
}
public void deleteBook(String bookId) throws Exception {

	Connection myConn = null;
	PreparedStatement myStmt = null;
	
	try {
		// convert student id to int
		int bookid = Integer.parseInt(bookId);
		
		// get connection to database
		myConn = dataSource.getConnection();
		
		// create sql to delete student
		String sql = "delete from book where id=?";
		
		// prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		// set params
		myStmt.setInt(1, bookid);
		
		// execute sql statement
		myStmt.execute();
	}
	finally {
		// clean up JDBC code
		close(myConn, myStmt, null);
	}	
}
public void addBook(Book book) throws Exception {

	Connection myConn = null;
	PreparedStatement myStmt = null;
	
	try {
		// get db connection
		myConn = dataSource.getConnection();
		
		// create sql for insert
		String sql = "insert into book "
				   + "(book_title,book_isbn,book_publicationyear,book_price,book_author_id,book_publisher_id,book_purchasedate,book_totalquantity,book_soldquantity,book_student_issueid) "
				   + "values (?, ?,?,?,?,?,?,?,?,?)";
		
		myStmt = myConn.prepareStatement(sql);
		
		java.util.Date publicationDate1 =  book.getPublicationDate();
		java.sql.Date publicationDate = new java.sql.Date(publicationDate1.getTime());
		
		java.util.Date purchaseDate1 = book.getPurchaseDate();
		java.sql.Date purchaseDate = new java.sql.Date(purchaseDate1.getTime());
		
		// set the param values for the student
		myStmt.setString(1, book.getBookTitle());
		myStmt.setInt(2, book.getIsbnNo());
		myStmt.setDate(3, publicationDate);
		myStmt.setInt(4, book.getPrice());
		myStmt.setInt(5, book.getAuthorId());
		myStmt.setInt(6, book.getPublisherId());
		myStmt.setDate(7, purchaseDate);
		myStmt.setInt(8, book.getQuantity());
		myStmt.setInt(9, book.getSoldquantity());
		myStmt.setInt(10, 1);
		// execute sql insert
		myStmt.execute();
	}
	finally {
		// clean up JDBC objects
		close(myConn, myStmt, null);
	}
}
public void updateBook(Book book) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update book "
						+ "set book_title = ?,book_isbn =  ?,book_publicationyear = ?,book_price = ?,book_author_id = ?,book_publisher_id = ?,book_purchasedate = ?,book_totalquantity =?,book_soldquantity =?,book_student_issueid = ?"
						+ "where book_id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			

			java.util.Date publicationDate1 =  book.getPublicationDate();
			java.sql.Date publicationDate = new java.sql.Date(publicationDate1.getTime());
			
			java.util.Date purchaseDate1 = book.getPurchaseDate();
			java.sql.Date purchaseDate = new java.sql.Date(purchaseDate1.getTime());
			
			// set params
			myStmt.setString(1, book.getBookTitle());
			myStmt.setInt(2, book.getIsbnNo());
			myStmt.setDate(3, publicationDate);
			myStmt.setInt(4, book.getPrice());
			myStmt.setInt(5, book.getAuthorId());
			myStmt.setInt(6, book.getPublisherId());
			myStmt.setDate(7, purchaseDate);
			myStmt.setInt(8, book.getQuantity());
			myStmt.setInt(9, book.getSoldquantity());
			myStmt.setInt(10, 1);
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}



}
