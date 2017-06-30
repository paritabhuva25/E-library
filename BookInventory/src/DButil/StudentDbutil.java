package DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import pojo.Student;

public class StudentDbutil {
	
private DataSource dataSource;
	
	public StudentDbutil(DataSource thedataSource) {
		// TODO Auto-generated constructor stub
		
		dataSource = thedataSource;
	}
	
public List<Student> getStudent() throws Exception {
		
		List<Student> studentlist = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from student order by student_name";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				
				String studentName = myRs.getString("student_name");
				
				Date studentIssuedate = myRs.getDate("student_issuedate");
				
				
				String studentbookName = myRs.getString("student_bookName"); 
				
				// create new student object
				Student  student = new Student(studentName, studentIssuedate, studentbookName);
				
				
				studentlist.add(student);				
			}
			
			return studentlist;		
		
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
public void addStudent(Student student) throws Exception {
	

	Connection myConn = null;
	PreparedStatement myStmt = null;
	
	try {
		// get db connection
		myConn = dataSource.getConnection();
		
		// create sql for insert
		String sql = "insert into student "
				   + "(student_name,student_issuedate,student_bookName) "
				   + "values (?, ?, ?)";
		
		myStmt = myConn.prepareStatement(sql);
		
		
		java.util.Date studentIssuedate1 = student.getStudentIssuedate();
		java.sql.Date studentIssuedate = new java.sql.Date(studentIssuedate1.getTime());
		
		// set the param values for the student
		myStmt.setString(1, student.getStudentName());
		myStmt.setDate(2, studentIssuedate );
		myStmt.setString(3, student.getStudentbookName());
		
		// execute sql insert
		myStmt.execute();
	}
	finally {
		// clean up JDBC objects
		close(myConn, myStmt, null);
	}
}
}
