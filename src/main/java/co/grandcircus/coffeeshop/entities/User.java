package co.grandcircus.coffeeshop.entities;

public class User {

	private Long id;
	private String username;
	private String password;
	private String yourname;

	public User() {

	}


	public User(Long id, String username, String password, String yourname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.yourname = yourname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getYourname() {
		return yourname;
	}

	public void setYourname(String yourname) {
		this.yourname = yourname;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", yourname=" + yourname + "]";
	}
}
