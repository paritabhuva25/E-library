package pojo;

public class User {
	
		private int id;
		private String Username;
		private String password;
		private int mobilenumber;
		
		
		
		public User( String username, String password, int mobilenumber) {
		
			Username = username;
			this.password = password;
			this.mobilenumber = mobilenumber;
		}

		public User(String Username, String password) {
			this.Username = Username;
			this.password = password;
			
		}

		public User(int id, String Username, String password) {
			this.id = id;
			this.Username = Username;
			this.password = password;
			
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUsername() {
			return Username;
		}

		public void setUsername(String username) {
			Username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getMobilenumber() {
			return mobilenumber;
		}

		public void setMobilenumber(int mobilenumber) {
			this.mobilenumber = mobilenumber;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", Username=" + Username + ", password=" + password + ", mobilenumber="
					+ mobilenumber + "]";
		}

}
