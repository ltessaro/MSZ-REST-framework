package com.msz.dao.hibernate.imp;

import java.util.logging.Logger;

import com.msz.dao.ITaskDAO;
import com.msz.dao.hibernate.AbstractGenericDAO;
import com.msz.model.Task;

public class TaskDAOImp extends AbstractGenericDAO<Task, Long> implements ITaskDAO {
	private final static Logger logger = Logger.getLogger(TaskDAOImp.class.getName());

	@Override
	protected Class<Task> getModelClass() {
		return Task.class;
	}
}