package com.nikola.dao;

import com.nikola.model.UserModel;

public interface UserDao {
	
	Integer authUser(String email);

	UserModel getUserById(int id);
	
	UserModel addUser(String firstname, String lastname, String username, String email, String pass);
}
