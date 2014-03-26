package com.msz.dao;

import com.msz.model.User;

public interface UserDAO {
	public User findByID(Long id);
	public User findByPlayer(Long playerID);
	
	public Boolean delete(Long id);
	public Boolean save(User user);
}
