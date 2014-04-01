package com.msz.dao.hibernate;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

public class PersistenceProducer {
	public static final String MSZJPA_PERSISTENCE = "MSZJPA";

	@Produces
	@PersistenceUnit(unitName=MSZJPA_PERSISTENCE)
	@ApplicationScoped
	public EntityManagerFactory create() {
		return Persistence.createEntityManagerFactory(MSZJPA_PERSISTENCE);
	}

	public void destroy(@Disposes EntityManagerFactory factory) {
		factory.close();
	}
}