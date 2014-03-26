package com.msz.dao;

import java.util.List;

import com.msz.model.Match;

public interface MatchDAO {
	public Match findByID(Long id);
	public List<Match> listByPlayer(Long playerID);
	
	public Boolean delete(Long id);
	public Boolean save(Match match);
}
