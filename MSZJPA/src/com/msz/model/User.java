package com.msz.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MSZUser")
public class User implements Serializable {
	private static final long serialVersionUID = 2135792575000845649L;

	@Id
	private Long id;

	private String email;
	private String password;

	private String facebookID;
	private String facebookToken;
	private String facebookPermissions;
	private Date facebookActiveSince;

	private Date createdAt;
	private Date lastLogin;

	private Player player;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFacebookID() {
		return facebookID;
	}

	public void setFacebookID(String facebookID) {
		this.facebookID = facebookID;
	}

	public String getFacebookToken() {
		return facebookToken;
	}

	public void setFacebookToken(String facebookToken) {
		this.facebookToken = facebookToken;
	}

	public String getFacebookPermissions() {
		return facebookPermissions;
	}

	public void setFacebookPermissions(String facebookPermissions) {
		this.facebookPermissions = facebookPermissions;
	}

	public Date getFacebookActiveSince() {
		return facebookActiveSince;
	}

	public void setFacebookActiveSince(Date facebookActiveSince) {
		this.facebookActiveSince = facebookActiveSince;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}