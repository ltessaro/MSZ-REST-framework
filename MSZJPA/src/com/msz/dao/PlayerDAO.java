package com.msz.dao;

import java.util.List;

import com.msz.model.Player;

public interface PlayerDAO {
	public Player findByID(Long id);
	public List<Player> listByName(String name);
	
	public Boolean delete(Long id);
	public Boolean save(Player player);
}
