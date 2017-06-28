package pojo;

public class Buybook {
	
	private int buybookId;
	private int userId;
	private int bookId;
	private int quantity;
	private String status;
	
	public Buybook(int buybookId, int userId, int bookId, int quantity, String status) {
		super();
		this.buybookId = buybookId;
		this.userId = userId;
		this.bookId = bookId;
		this.quantity = quantity;
		this.status = status;
	}
	public Buybook(int userId, int bookId, int quantity, String status) {
		super();
		this.userId = userId;
		this.bookId = bookId;
		this.quantity = quantity;
		this.status = status;
	}
	public int getBuybookId() {
		return buybookId;
	}
	public void setBuybookId(int buybookId) {
		this.buybookId = buybookId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Buybook [buybookId=" + buybookId + ", userId=" + userId + ", bookId=" + bookId + ", quantity="
				+ quantity + ", status=" + status + "]";
	}
	
	

}
