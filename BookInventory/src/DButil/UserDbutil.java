package DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import pojo.User;

public class UserDbutil {
	
	private DataSource dataSource;

	public UserDbutil(DataSource theDataSource) {
		dataSource = theDataSource;
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
			String sql = "select * from register";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				
				String username = myRs.getString("reg_username");
				String password = myRs.getString("reg_password");
				String mobilenumber1 = myRs.getString("reg_mobilenumber");
				int mobilenumber = Integer.parseInt(mobilenumber1);
				// create new student object
				User usercreated = new User(username,password,mobilenumber);
				
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
		String sql = "insert into register "
				   + "(reg_username,reg_password,reg_mobilenumber) "
				   + "values (?, ?, ?)";
		
		myStmt = myConn.prepareStatement(sql);
		
		// set the param values for the student
		myStmt.setString(1, user.getUsername());
		myStmt.setString(2, user.getPassword());
		myStmt.setInt(3, user.getMobilenumber());

		// execute sql insert
		myStmt.execute();
	}
	finally {
		// clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

}
