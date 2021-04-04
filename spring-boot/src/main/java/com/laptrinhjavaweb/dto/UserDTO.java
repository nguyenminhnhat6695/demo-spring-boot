package com.laptrinhjavaweb.dto;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.entity.RoleEntity;

public class UserDTO extends AbstractDTO<UserDTO> {

	private String username;

	private String password;

	private String full_name;

	private String password_confirm;

	private Integer status;

	private List<RoleEntity> roles = new ArrayList<>();

	private Integer number_phone;

	private String email;

	private String address;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getPassword_confirm() {
		return password_confirm;
	}

	public void setPassword_confirm(String password_confirm) {
		this.password_confirm = password_confirm;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public Integer getNumber_phone() {
		return number_phone;
	}

	public void setNumber_phone(Integer number_phone) {
		this.number_phone = number_phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
