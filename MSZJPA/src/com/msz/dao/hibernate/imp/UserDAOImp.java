package com.msz.dao.hibernate.imp;

import java.util.logging.Logger;

import com.msz.dao.IUserDAO;
import com.msz.dao.hibernate.AbstractGenericDAO;
import com.msz.model.User;

public class UserDAOImp extends AbstractGenericDAO<User, Long> implements IUserDAO {
	private final static Logger logger = Logger.getLogger(UserDAOImp.class.getName());

	@Override
	protected Class<User> getModelClass() {
		return User.class;
	}
}
