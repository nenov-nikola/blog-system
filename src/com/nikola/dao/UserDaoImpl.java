package com.nikola.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nikola.model.UserModel;
import com.nikola.utils.EmailValidator;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private EmailValidator emailValidator;

	@Override
	@Transactional
	public Integer authUser(String email) {
		if (!emailValidator.isValidEmailAddress(email)) {
			throw new IllegalArgumentException();
		}

		try {
			int id = (int) em.createQuery("select userId from UserModel where email = :email")
					.setParameter("email", email).getSingleResult();
			return id;
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public UserModel getUserById(int id) {
		UserModel user = em.find(UserModel.class, id);
		return user;
	}

	@Override
	@Transactional
	public UserModel addUser(String firstname, String lastname, String username, String email, String pass) {
		Session session = em.unwrap(Session.class);
		Transaction t = session.beginTransaction();
		UserModel user = new UserModel(firstname, lastname, username, email, pass);
		session.saveOrUpdate(user);
		t.commit();
		return user;
	}

}
