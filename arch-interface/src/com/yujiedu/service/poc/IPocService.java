package com.yujiedu.service.poc;

import java.util.List;

import com.yujiedu.orm.poc.PocUser;

public interface IPocService {
	void log(String msg);

	List<PocUser> findAllPocUsers();

	PocUser findUserById(String userId);
	List<PocUser> findUsersById(String userId);
	
	void changeState();
}
