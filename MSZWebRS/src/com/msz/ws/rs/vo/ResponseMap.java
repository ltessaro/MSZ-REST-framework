package com.msz.ws.rs.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseMap implements Serializable {
	private static final long serialVersionUID = 6797668981654643997L;

	@XmlElement
	private boolean error;
	@XmlElement
	private String message;
	private Object data;

	public ResponseMap(boolean error, String message) {
		this.error = error;
		this.message = message;
	}

	public ResponseMap() {
		this.error = false;
		this.message = null;
	}

	public boolean isError() {
		return error;
	}

	public String getMessage() {
		return message;
	}

	@XmlElement
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}