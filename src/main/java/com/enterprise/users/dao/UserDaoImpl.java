package com.enterprise.users.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.enterprise.users.model.User;

@Repository
@Transactional(readOnly = true)
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User getUser(String firstName) {
		Query query = sessionFactory.openSession().createQuery(
				"from User where firstName = :firstName ");
		query.setParameter("firstName", firstName);
		return (User) query.list().get(0);
	}

	@Override
	@Transactional(readOnly = false)
	public void insertUser(User user) {
		System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getAge() );
		sessionFactory.openSession().save(user);
	}

	@Override
	public void deleteUser(User user) {
		Query query = sessionFactory.openSession().createQuery(
				"delete User where id = :id");
		query.setParameter("id", user.getId());
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		return sessionFactory.openSession().createQuery("FROM User").list();
	}

	@Override
	public void updateUser(User user) {
		Query query = sessionFactory.openSession().createQuery(
				"update User set firstName = :firstName" + " where id = :id");
		query.setParameter("firstName", user.getFirstName());
		query.setParameter("id", user.getId());
		query.executeUpdate();

	}

}
