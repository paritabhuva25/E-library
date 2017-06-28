package DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import Controller.Author;

public class AuthorDbutil {

	private DataSource dataSource;
	
	public AuthorDbutil(DataSource thedataSource) {
		// TODO Auto-generated constructor stub
		
		dataSource = thedataSource;
	}
	
public List<Author> getAuthor() throws Exception {
		
		List<Author> authorlist = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from author order by author_name";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				
				String authorName = myRs.getString("author_name");
				String bookName = myRs.getString("author_bookName"); 
				// create new student object
				Author author = new Author(authorName, bookName);
				
				
				authorlist.add(author);				
			}
			
			return authorlist;		
		
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
public void addAuthor(Author author) throws Exception {
	

	Connection myConn = null;
	PreparedStatement myStmt = null;
	
	try {
		// get db connection
		myConn = dataSource.getConnection();
		
		// create sql for insert
		String sql = "insert into author "
				   + "(author_name,author_bookName) "
				   + "values (?, ?)";
		
		myStmt = myConn.prepareStatement(sql);
		
		// set the param values for the student
		myStmt.setString(1, author.getAuthorName());
		myStmt.setString(2, author.getAuthorbookName());
		
		// execute sql insert
		myStmt.execute();
	}
	finally {
		// clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

}