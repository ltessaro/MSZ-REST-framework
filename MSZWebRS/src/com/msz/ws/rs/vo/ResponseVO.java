package com.msz.ws.rs.vo;

import java.io.Serializable;

import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.NONE)
public class ResponseVO implements Serializable {
	private static final long serialVersionUID = 6797668981654643997L;

	@XmlElement
	private boolean error;
	@XmlElement
	private String message;
	@XmlElement
	private Object data;

	public static Builder ok() {
		return new ResponseVO.Builder(false);
	}

	public static Builder ok(Serializable entity) {
		return new ResponseVO.Builder(false).data(entity);
	}

	public static Builder error(String msg) {
		return new ResponseVO.Builder(true).message(msg);
	}

	public static class Builder {
		private boolean error;
		private String message;
		private Object data;

		private Builder(boolean error) {
			this.error = error;
		}

		public Builder error(boolean error) {
			this.error = error;
			return this;
		}

		public Builder message(String message) {
			this.message = message;
			return this;
		}

		private Builder data(Object data) {
			this.data = data;
			return this;
		}

		public ResponseVO build() {
			ResponseVO response = new ResponseVO();
			response.error = this.error;
			response.message = this.message;
			response.data = this.data;

			return response;
		}

		public Response buildResponse() {
			return Response.accepted().entity(this.build()).build();
		}
	}

	private ResponseVO() {
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) { this.error = error; }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) { this.message = message; }

	public Object getData() {
		return data;
	}

	public void setData(Object data) { this.data = data; }

}