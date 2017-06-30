package DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import pojo.Publisher;


public class PublisherDbutil {

	private DataSource dataSource;
	
	public PublisherDbutil(DataSource thedataSource) {
		// TODO Auto-generated constructor stub
		
		dataSource = thedataSource;
	}
	
public List<Publisher> getPublisher() throws Exception {
		
		List<Publisher> publisherlist = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from publisher order by publisher_name";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				
				String publisherName = myRs.getString("publisher_name");
				String publisherCountry = myRs.getString("publisher_country");
				String contactNumber1 = myRs.getString("publisher_phonenumber");
				int contactNumber = Integer.parseInt(contactNumber1);
				String bookName = myRs.getString("book_name"); 
				// create new student object
				Publisher publisher = new Publisher(publisherName, publisherCountry, contactNumber, bookName);
				
				
				publisherlist.add(publisher);				
			}
			
			return publisherlist;		
		
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
public void addPublisher(Publisher publisher) throws Exception {
	

	Connection myConn = null;
	PreparedStatement myStmt = null;
	
	try {
		// get db connection
		myConn = dataSource.getConnection();
		
		// create sql for insert
		String sql = "insert into publisher "
				   + "(publisher_name,publisher_country,publisher_phonenumber,book_name) "
				   + "values (?, ?, ?, ?)";
		
		myStmt = myConn.prepareStatement(sql);
		
		// set the param values for the student
		myStmt.setString(1, publisher.getPublisherName());
		myStmt.setString(2, publisher.getPublisherCountry());
		myStmt.setInt(3, publisher.getContactNumber());
		myStmt.setString(4, publisher.getBookName());

		// execute sql insert
		myStmt.execute();
	}
	finally {
		// clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

}

		

