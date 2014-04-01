package com.msz.ws.rs.vo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.msz.model.User;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.NONE)
public class UserVO implements Serializable {
	private static final long serialVersionUID = -5465527094902353975L;

	@XmlElement
	private Long id;
	@XmlElement
	private String accessToken;
	@XmlElement
	private String email;
	@XmlElement
	private String password;
	@XmlElement
	private String facebookID;
	@XmlElement
	private Date signedInAt;

	public static final UserVO build(User user) {
		if (user == null)
			return null;

		UserVO vo = new UserVO();
		vo.accessToken = user.getAccessToken();
		vo.email = user.getEmail();
		vo.facebookID = user.getFacebookID();
		vo.id = user.getId();
		vo.password = user.getPassword();
		vo.signedInAt = user.getSignedInAt();

		return vo;
	}

	public User toModel() {
		User user = new User();

		user.setAccessToken(this.accessToken);
		user.setEmail(this.email);
		user.setFacebookID(this.facebookID);
		user.setId(this.id);
		user.setPassword(this.password);
		user.setSignedInAt(this.signedInAt);

		return user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
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

	public Date getSignedInAt() {
		return signedInAt;
	}

	public void setSignedInAt(Date signedInAt) {
		this.signedInAt = signedInAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}