package pojo;

import java.util.Date;

public class Student {

	private int studentId;
	private String studentName;
	private Date studentIssuedate;
	private String studentbookName;
	public Student(String studentName, Date studentIssuedate, String studentbookName) {
		super();
		this.studentName = studentName;
		this.studentIssuedate = studentIssuedate;
		this.studentbookName = studentbookName;
	}
	public Student(int studentId, String studentName, Date studentIssuedate, String studentbookName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentIssuedate = studentIssuedate;
		this.studentbookName = studentbookName;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Date getStudentIssuedate() {
		return studentIssuedate;
	}
	public void setStudentIssuedate(Date studentIssuedate) {
		this.studentIssuedate = studentIssuedate;
	}
	public String getStudentbookName() {
		return studentbookName;
	}
	public void setStudentbookName(String studentbookName) {
		this.studentbookName = studentbookName;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentIssuedate="
				+ studentIssuedate + ", studentbookName=" + studentbookName + "]";
	}
	
	
	
}
