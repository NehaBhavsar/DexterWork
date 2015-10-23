package org.dexterwork.dao;

import org.dexterwork.entity.MstUser;
import org.dexterwork.exception.DatabaseException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		if (null != sessionFactory)
			return sessionFactory.getCurrentSession();

		throw new DatabaseException();
	}

	@Override
	public int createUser(MstUser user) {
		int userid = (Integer) getSession().save(user);
		return userid;
	}

}
