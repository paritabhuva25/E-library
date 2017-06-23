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
public List<Book> getStudents() throws Exception {
		
		List<Book> book = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from book order by book_title";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				
				String bookTitle = myRs.getString("booktitle");
				
				String isbnNo1 = myRs.getString("isbnno");
				int isbnNo = Integer.parseInt(isbnNo1);
				
				String price1 = myRs.getString("price");
				int price =  Integer.parseInt(price1);
				
				String authorId1 = myRs.getString("authorId1");
				int authorId =  Integer.parseInt(price1);
				
				String publisherId1 = myRs.getString("publisherId");
				int publisherId = Integer.parseInt(publisherId1);
				
				String studentId1 = myRs.getString("studentId");
				int studentId = Integer.parseInt(studentId1);
				
				String quantity1 = myRs.getString("quantity");
				int quantity = Integer.parseInt(quantity1);
				
				String soldquantity1 = myRs.getString("soldquantity");
				int soldquantity = Integer.parseInt(soldquantity1);

				String publicationDate = myRs.getString("publicationDate");
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date myDate = formatter.parse(publicationDate);
				
				String purchaseDate = myRs.getString("purchaseDate");
				java.util.Date myDate1 = formatter.parse(purchaseDate);
				
				// create new student object
				Book bookdetail = new Book(bookTitle, isbnNo, price, authorId, publisherId, studentId, quantity, soldquantity, publicationDate, purchaseDate);
				
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
public void addBook(Book book) throws Exception {

	Connection myConn = null;
	PreparedStatement myStmt = null;
	
	try {
		// get db connection
		myConn = dataSource.getConnection();
		
		// create sql for insert
		String sql = "insert into book "
				   + "(book_title,book_isbn,book_publicationyear,book_price,book_author_id,book_publisher_id,book_purchasedate,book_totalquantity,book_soldquantity,book_student_issueid) "
				   + "values (?, ?)";
		
		myStmt = myConn.prepareStatement(sql);
		
		String publicationDate1 = book.getPublicationDate();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date publicationDate = (Date) formatter.parse(publicationDate1);
		
		String purchaseDate1 = book.getPurchaseDate();
		Date purchaseDate = (Date) formatter.parse(purchaseDate1);
		
		// set the param values for the student
		myStmt.setString(1, book.getBookTitle());
		myStmt.setInt(2, book.getIsbnNo());
		myStmt.setDate(3, publicationDate);
		myStmt.setInt(4, book.getPrice());
		myStmt.setInt(5, book.getAuthorId());
		myStmt.setDate(6, purchaseDate);
		myStmt.setInt(7, x);
		// execute sql insert
		myStmt.execute();
	}
	finally {
		// clean up JDBC objects
		close(myConn, myStmt, null);
	}
}



}
