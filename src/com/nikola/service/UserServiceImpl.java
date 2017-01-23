package com.nikola.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import com.nikola.dao.UserDao;
import com.nikola.exception.UserException;
import com.nikola.model.UserModel;
import com.nikola.utils.EmailValidator;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private EmailValidator emailValidator;

	@PersistenceContext
	private EntityManager em;

	@Override
	public Integer authUser(String email) throws UserException {
		if (emailValidator.isValidEmailAddress(email)) {
			return userDao.authUser(HtmlUtils.htmlEscape(email));
		} else {
			throw new UserException("Write correct your email please.");
		}
	}

	@Override
	public UserModel getUserById(int id) throws UserException {
		UserModel user = em.find(UserModel.class, id);
		if (user == null) {
			throw new UserException("User with that id do not exist.");
		} else {
			return userDao.getUserById(id);
		}
	}

	@Override
	public UserModel addUser(String firstname, String lastname, String username, String email, String pass)
			throws UserException {
		if (emailValidator.isValidEmailAddress(email)) {
			return userDao.addUser(HtmlUtils.htmlEscape(firstname), HtmlUtils.htmlEscape(lastname),
					HtmlUtils.htmlEscape(username), HtmlUtils.htmlEscape(email), HtmlUtils.htmlEscape(pass));
		} else {
			throw new UserException("Please fill registration fields correct.");
		}

	}

}
