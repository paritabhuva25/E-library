package Controller;

public class Publisher {

	private int publisherId; 
	private String publisherName;
	private String publisherCountry;
	private int contactNumber;
	private String bookName;
	public Publisher(String publisherName, String publisherCountry, int contactNumber, String bookName) {
		super();
		this.publisherName = publisherName;
		this.publisherCountry = publisherCountry;
		this.contactNumber = contactNumber;
		this.bookName = bookName;
	}
	public Publisher(int publisherId ,String publisherName, String publisherCountry, int contactNumber, String bookName) {
		super();
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.publisherCountry = publisherCountry;
		this.contactNumber = contactNumber;
		this.bookName = bookName;
	}
	
	
	
} 
