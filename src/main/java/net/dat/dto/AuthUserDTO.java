package net.dat.dto;

public class AuthUserDTO {
	private Integer userId;
	private String username;
	private String fullname;
	private String role;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
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

	public AuthUserDTO(Integer userId, String username, String fullname, String role) {
		super();
		this.userId = userId;
		this.username = username;
		this.fullname = fullname;
		this.role = role;
	}

}
