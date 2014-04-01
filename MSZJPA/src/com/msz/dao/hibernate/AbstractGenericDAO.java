package com.msz.dao.hibernate;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.msz.dao.IGenericDAO;

public abstract class AbstractGenericDAO<T, PK extends Serializable> implements IGenericDAO<T, PK> {
	@Inject
	private EntityManagerFactory emf;
	private EntityManager em;

	public EntityManager getEntityManager() {
		if (this.em == null) { em = emf.createEntityManager(); }
		return emf.createEntityManager();
	}
	
	protected abstract Class<T> getModelClass();
	
	@Override
	public T create(T t) {
		if (t != null) {
			getEntityManager().persist(t);
			getEntityManager().flush();
			return t;
		}
		return null;
	}

	@Override
	public T findByID(PK id) {
		if (id != null) {
			return getEntityManager().find(getModelClass(), id);
		}
		return null;
	}

	@Override
	public T update(T t) {
		if (t != null) {
			emf.createEntityManager().persist(t);
			emf.createEntityManager().flush();
			return t;
		}
		return null;
	}

	@Override
	public boolean delete(T t) {
		if (t != null) {
			emf.createEntityManager().persist(t);
			emf.createEntityManager().flush();
			return true;
		}
		return false;
	}

}
