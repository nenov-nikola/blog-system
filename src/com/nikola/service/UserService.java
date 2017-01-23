package com.nikola.service;

import com.nikola.exception.UserException;
import com.nikola.model.UserModel;

public interface UserService {

	Integer authUser(String email) throws UserException;

	UserModel getUserById(int id) throws UserException;

	UserModel addUser(String firstname, String lastname, String username, String email, String pass)
			throws UserException;
}
