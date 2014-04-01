package com.msz.ws.rs.vo;

import java.io.Serializable;

public class EntityID implements Serializable {
	private static final long serialVersionUID = -4142481280274869976L;

	private Long id;

	public EntityID(Long id) { this.setId(id); }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}