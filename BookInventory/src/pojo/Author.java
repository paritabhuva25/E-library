package pojo;

public class Author {

	private int authorId;
	private String authorName;
	private String authorbookName;
	
	public Author(int authorId, String authorName, String authorbookName) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorbookName = authorbookName;
	}

	public Author(String authorName, String authorbookName) {
		super();
		this.authorName = authorName;
		this.authorbookName = authorbookName;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorbookName() {
		return authorbookName;
	}

	public void setAuthorbookName(String authorbookName) {
		this.authorbookName = authorbookName;
	}

	@Override
	public String toString() {
		return "Auhtor [authorId=" + authorId + ", authorName=" + authorName + ", authorbookName=" + authorbookName
				+ "]";
	}
	
	

}
