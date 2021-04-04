package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.entity.UserEntity;

public interface UserService {
	void save(UserEntity userEntity);
	
	UserEntity findByUsername(String username);
}
