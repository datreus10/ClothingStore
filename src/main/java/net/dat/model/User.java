package net.dat.model;

public class User {
	private Integer id;
	private String username;
	private String password;
	private String fullname;
	private String phone;
	private String address;
	private String role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public User(String username, String password, String fullname, String phone, String address, String role) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.phone = phone;
		this.address = address;
		this.role = role;
	}

	public User(Integer id, String username, String password, String fullname, String phone, String address,
			String role) {
		this(username,password,fullname,phone,address,role);
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", fullname=" + fullname
				+ ", phone=" + phone + ", address=" + address + ", role=" + role + "]";
	}
	
}
