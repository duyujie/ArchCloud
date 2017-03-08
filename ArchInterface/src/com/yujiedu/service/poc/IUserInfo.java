package com.yujiedu.service.poc;

import java.io.Serializable;

public interface IUserInfo extends Serializable {

	String getEmail();

	String getStatus();

	String getMobile();

	String getUserId();

	String getOrgId();

	String getUserName();

	String getPassword();

	void setEmail(String email);

	void setStatus(String status);

	void setMobile(String mobile);

	void setUserId(String userId);

	void setOrgId(String orgId);

	void setUserName(String userName);

	void setPassword(String password);

}
