package org.dexterwork.dao;

import java.util.List;

import org.dexterwork.entity.MstUser;
import org.dexterwork.exception.DatabaseException;
import org.dexterwork.model.RespCode;
import org.dexterwork.model.User;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
		return (List<User>) getSession().createCriteria(MstUser.class).list();
	}

	@Override
	public MstUser getUserById(int userId) {
		return (MstUser) getSession().get(MstUser.class, userId);
	}

	@Override
	public RespCode deleteUserById(int userId) {
		MstUser mstUser = (MstUser) getSession().get(MstUser.class, userId);
		if (null != mstUser) {
			getSession().delete(mstUser);
			return RespCode.SUCCESS;
		} else
			return RespCode.FAILURE;

	}

}
