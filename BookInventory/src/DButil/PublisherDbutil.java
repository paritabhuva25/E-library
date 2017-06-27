package DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import Controller.Publisher;
import Controller.User;

public class PublisherDbutil {

	private DataSource dataSource;
	
	public PublisherDbutil(DataSource thedataSource) {
		// TODO Auto-generated constructor stub
		
		dataSource = thedataSource;
	}
	
public List<User> getStudents() throws Exception {
		
		List<User> user = new ArrayList<>();
		
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
				
				// add it to the list of students
				user.add(usercreated);				
			}
			
			return user;		
		
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
public void addStudent(User user) throws Exception {

	Connection myConn = null;
	PreparedStatement myStmt = null;
	
	try {
		// get db connection
		myConn = dataSource.getConnection();
		
		// create sql for insert
		String sql = "insert into user "
				   + "(user_name,user_password) "
				   + "values (?, ?)";
		
		myStmt = myConn.prepareStatement(sql);
		
		// set the param values for the student
		myStmt.setString(1, user.getUsername());
		myStmt.setString(2, user.getPassword());
		
		// execute sql insert
		myStmt.execute();
	}
	finally {
		// clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

}

		

