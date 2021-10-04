package com.swagger.POJOs;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "username", "firstName", "lastName", "email", "password", "phone", "userStatus" })

public class UserData {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("username")
	private String username;
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("email")
	private String email;
	@JsonProperty("password")
	private String password;
	@JsonProperty("phone")
	private String phone;
	@JsonProperty("userStatus")
	private Integer userStatus;

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("username")
	public String getUsername() {
		return username;
	}

	@JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}

	@JsonProperty("firstName")
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("firstName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty("lastName")
	public String getLastName() {
		return lastName;
	}

	@JsonProperty("lastName")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	@JsonProperty("password")
	public void setPassword(String password) {
		this.password = password;
	}

	@JsonProperty("phone")
	public String getPhone() {
		return phone;
	}

	@JsonProperty("phone")
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@JsonProperty("userStatus")
	public Integer getUserStatus() {
		return userStatus;
	}

	@JsonProperty("userStatus")
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(UserData.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("username");
		sb.append('=');
		sb.append(((this.username == null) ? "<null>" : this.username));
		sb.append(',');
		sb.append("firstName");
		sb.append('=');
		sb.append(((this.firstName == null) ? "<null>" : this.firstName));
		sb.append(',');
		sb.append("lastName");
		sb.append('=');
		sb.append(((this.lastName == null) ? "<null>" : this.lastName));
		sb.append(',');
		sb.append("email");
		sb.append('=');
		sb.append(((this.email == null) ? "<null>" : this.email));
		sb.append(',');
		sb.append("password");
		sb.append('=');
		sb.append(((this.password == null) ? "<null>" : this.password));
		sb.append(',');
		sb.append("phone");
		sb.append('=');
		sb.append(((this.phone == null) ? "<null>" : this.phone));
		sb.append(',');
		sb.append("userStatus");
		sb.append('=');
		sb.append(((this.userStatus == null) ? "<null>" : this.userStatus));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}