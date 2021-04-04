package com.laptrinhjavaweb.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		UserEntity userEntity = userRepository.findByUsername(userName);
		
		if (userEntity == null) {
			throw new UsernameNotFoundException(userName);
		}

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (RoleEntity roleEntity : userEntity.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(roleEntity.getName()));
		}

		
		
		return new org.springframework.security.core.userdetails.User(userEntity.getUsername(),
				userEntity.getPassword(), grantedAuthorities);
	}

}
