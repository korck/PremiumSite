package users;

public class User {
	private String username;
	private String password;
	private String email;
	private int permissions;
	
	public User(String username, String password, String email, int permissions) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.permissions = permissions;
	}
	
	public User() {
		
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public int getPermissions() {
		return permissions;
	}

	public void setPermissions(int permissions) {
		this.permissions = permissions;
	}
}
