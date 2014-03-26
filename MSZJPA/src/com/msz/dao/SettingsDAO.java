package com.msz.dao;

import com.msz.model.Settings;

public interface SettingsDAO {
	public Settings findByID(Long id);
	public Settings findByPlayer(Long playerID);

	public Boolean delete(Long id);
	public Boolean save(Settings settings);
}
