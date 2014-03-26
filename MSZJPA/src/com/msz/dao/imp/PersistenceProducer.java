package com.msz.dao.imp;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

public class PersistenceProducer {
	    @Produces
	    @PersistenceContext(unitName="MSZJPA")
	    @Dependent
	    EntityManager entityManager;

	    @Produces
	    @PersistenceUnit(unitName="MSZJPA")
	    @Dependent
	    EntityManagerFactory entityManagerFactory;
}