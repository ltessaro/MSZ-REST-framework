package com.msz.dao;

import java.util.List;

import com.msz.model.Invite;

public interface InviteDAO {
	public Invite findByID(Long id);
	public List<Invite> listByMatch(Long matchID);
	public List<Invite> listByPlayer(Long playerID);

	public Boolean updateStatus(Long inviteID, String status);

	public Boolean delete(Long id);
	public Boolean save(Invite invite);
}