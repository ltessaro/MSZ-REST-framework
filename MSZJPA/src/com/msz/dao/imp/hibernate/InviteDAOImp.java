package com.msz.dao.imp.hibernate;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.msz.dao.InviteDAO;
import com.msz.model.Invite;

public class InviteDAOImp implements InviteDAO {

	private final static Logger logger = Logger.getLogger(InviteDAOImp.class.getName());
	
	private @Inject EntityManager em;
	
	@Override
	public Invite findByID(Long id) {
		try {
			logger.info(String.format("EntityManager: %s", em));
			TypedQuery<Invite> query = em.createQuery("SELECT invite FROM Invite WHERE id = ?1", Invite.class);
			query.setParameter(1, id);
			return query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			logger.severe(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Invite> listByMatch(Long matchID) {
		try {
			TypedQuery<Invite> query = em.createQuery("SELECT invite FROM Invite WHERE invite.match.id = ?1", Invite.class);
			query.setParameter(1, matchID);
			return query.getResultList();
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return Collections.emptyList();
		}
	}

	@Override
	public List<Invite> listByPlayer(Long playerID) {
		try {
			TypedQuery<Invite> query = em.createQuery("SELECT invite FROM Invite WHERE invite.player.id = ?1", Invite.class);
			query.setParameter(1, playerID);
			return query.getResultList();
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return Collections.emptyList();
		}
	}

	@Override
	public Boolean updateStatus(Long inviteID, String status) {
		Invite invite = this.findByID(inviteID);
		if (invite != null) {
			invite.setStatus(status);
			em.persist(invite);
			em.flush();
			return true;
		}
		return false;
	}

	@Override
	public Boolean delete(Long id) {
		Invite invite = this.findByID(id);
		if (invite != null) {
			em.remove(invite);
			em.flush();
			return true;
		}
		return false;
	}

	@Override
	public Boolean save(Invite invite) {
		if (invite != null) {
			em.persist(invite);
			em.flush();
			return true;
		}
		return false;
	}

}
