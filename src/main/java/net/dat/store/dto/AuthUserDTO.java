package net.dat.store.dto;

public class AuthUserDTO {
	private String userId;
	private String username;
	private String fullname;
	private String role;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public AuthUserDTO(String userId, String username, String fullname, String role) {
		super();
		this.userId = userId;
		this.username = username;
		this.fullname = fullname;
		this.role = role;
	}

}
