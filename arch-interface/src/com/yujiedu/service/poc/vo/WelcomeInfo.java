package com.yujiedu.service.poc.vo;

import java.io.Serializable;
import java.util.Date;

public class WelcomeInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1929307614270608460L;

	private String sessionId;
	private String userId;
	private String token;
	private Date createdDate;
	private Date serverNow = new Date();

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getServerNow() {
		return serverNow;
	}

	public void setServerNow(Date serverNow) {
		this.serverNow = serverNow;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WelcomeInfo other = (WelcomeInfo) obj;
		if (sessionId == null) {
			if (other.sessionId != null)
				return false;
		} else if (!sessionId.equals(other.sessionId))
			return false;
		return true;
	}

}
