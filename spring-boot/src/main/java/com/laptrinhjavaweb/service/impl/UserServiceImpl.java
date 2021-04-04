package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.RoleRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(UserEntity userEntity) {
		userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
		
		List<RoleEntity> roles = new ArrayList<>();
		String role = "USER";
		if (userEntity.getRoles().size() != 0 ) {
			role = "ADMIN";
		}
		
		roles.add(roleRepository.findByname(role));
		
		userEntity.setRoles(roles);
		userRepository.save(userEntity);
	}

	@Override
	public UserEntity findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
