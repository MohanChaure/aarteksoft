package com.aartek.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aartek.model.User;
import com.aartek.repository.LoginRepository;

/**
 * 
 * @author Vivek, 16/04/2015
 *
 */
@SuppressWarnings("unchecked")
@Repository
public class LoginRepositoryImpl implements LoginRepository {
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Find User
	 */

	public User findByUserName(String userName) {
		List<User> users = new ArrayList<User>();
		users = sessionFactory.getCurrentSession().createQuery("from User where userName=?").setParameter(0, userName)
						.list();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}
}