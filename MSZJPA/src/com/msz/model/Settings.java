package com.msz.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MSZSettings")
public class Settings implements Serializable {
	private static final long serialVersionUID = 2910160106418574829L;

	@Id
	private Long id;
	private Boolean sentToFacebook;
	private Boolean sentToEmail;
	private Boolean sentToApp;
	private User settings;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getSentToFacebook() {
		return sentToFacebook;
	}

	public void setSentToFacebook(Boolean sentToFacebook) {
		this.sentToFacebook = sentToFacebook;
	}

	public Boolean getSentToEmail() {
		return sentToEmail;
	}

	public void setSentToEmail(Boolean sentToEmail) {
		this.sentToEmail = sentToEmail;
	}

	public Boolean getSentToApp() {
		return sentToApp;
	}

	public void setSentToApp(Boolean sentToApp) {
		this.sentToApp = sentToApp;
	}

	public User getSettings() {
		return settings;
	}

	public void setSettings(User settings) {
		this.settings = settings;
	}
}