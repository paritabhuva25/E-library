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
	
	
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getPublisherCountry() {
		return publisherCountry;
	}
	public void setPublisherCountry(String publisherCountry) {
		this.publisherCountry = publisherCountry;
	}
	public int getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	
	@Override
	public String toString() {
		return "Publisher [publisherId=" + publisherId + ", publisherName=" + publisherName + ", publisherCountry="
				+ publisherCountry + ", contactNumber=" + contactNumber + ", bookName=" + bookName + "]";
	}
	
} 
