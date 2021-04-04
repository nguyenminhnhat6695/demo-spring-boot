package com.laptrinhjavaweb.service;

public interface SecurityService {
	String findLoggedInUsername();

	void autoLogin(String userName, String password);
}
