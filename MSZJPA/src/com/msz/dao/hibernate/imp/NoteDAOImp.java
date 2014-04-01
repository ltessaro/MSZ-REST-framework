package com.msz.dao.hibernate.imp;

import java.util.logging.Logger;

import com.msz.dao.INoteDAO;
import com.msz.dao.hibernate.AbstractGenericDAO;
import com.msz.model.Note;

public class NoteDAOImp extends AbstractGenericDAO<Note, Long> implements INoteDAO {
	private final static Logger logger = Logger.getLogger(NoteDAOImp.class.getName());
	
	@Override
	protected Class<Note> getModelClass() {
		return Note.class;
	}
}