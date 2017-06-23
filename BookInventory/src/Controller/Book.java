package Controller;

public class Book {

	private String bookTitle;
	private int isbnNo;
	private int price;
	private int authorId;
	private int publisherId;
	private int studentId;
	private int quantity;
	private int soldquantity;
	private String publicationDate;
	private String purchaseDate;

	
	public Book(String bookTitle, int isbnNo, int price, int authorId, int publisherId, int studentId, int quantity,
			int soldquantity, String publicationDate, String purchaseDate) {
		super();
		this.bookTitle = bookTitle;
		this.isbnNo = isbnNo;
		this.price = price;
		this.authorId = authorId;
		this.publisherId = publisherId;
		this.studentId = studentId;
		this.quantity = quantity;
		this.soldquantity = soldquantity;
		this.publicationDate = publicationDate;
		this.purchaseDate = purchaseDate;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public int getIsbnNo() {
		return isbnNo;
	}
	public void setIsbnNo(int isbnNo) {
		this.isbnNo = isbnNo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSoldquantity() {
		return soldquantity;
	}
	public void setSoldquantity(int soldquantity) {
		this.soldquantity = soldquantity;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	@Override
	public String toString() {
		return "Book [bookTitle=" + bookTitle + ", isbnNo=" + isbnNo + ", price=" + price + ", authorId=" + authorId
				+ ", publisherId=" + publisherId + ", studentId=" + studentId + ", quantity=" + quantity
				+ ", soldquantity=" + soldquantity + ", publicationDate=" + publicationDate + ", purchaseDate="
				+ purchaseDate + "]";
	}
	
	
	
	
}
