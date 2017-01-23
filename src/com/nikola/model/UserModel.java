package com.nikola.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name = "users")
public class UserModel {

	public static final String SESSION_PROPERTY = "auth";

	@Id
	@GeneratedValue
	private int userId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String username;
	@Column
	private String email;
	@Column
	private String pass;

	public UserModel() {
	}

	public UserModel(String firstName, String lastName, String username, String email, String pass) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.pass = pass;
	}

	public String getFirst_name() {
		return firstName;
	}

	public void setFirst_name(String first_name) {
		this.firstName = first_name;
	}

	public String getLast_name() {
		return lastName;
	}

	public void setLast_name(String last_name) {
		this.lastName = last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUser_id() {
		return userId;
	}

	public void setUser_id(int user_id) {
		this.userId = user_id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
