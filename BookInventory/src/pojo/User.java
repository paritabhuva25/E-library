package pojo;

public class User {
	
		private int id;
		private String Username;
		private String password;
		
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

		public void setUsername(String Username) {
			this.Username = Username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	

		@Override
		public String toString() {
			return "User [id=" + id + ", Username=" + Username + ", password=" + password + "]";
		}	
	
}
