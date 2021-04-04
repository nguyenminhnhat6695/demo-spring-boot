package com.laptrinhjavaweb.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.service.UserService;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserEntity.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserEntity userEntity = (UserEntity) target;

		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (userEntity.getUsername().length() < 3 || userEntity.getUsername().length() > 32) {
			errors.rejectValue("username", "Size.userForm.username");
		}
		
		if (userService.findByUsername(userEntity.getUsername()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (userEntity.getPassword().length() < 4 || userEntity.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!userEntity.getPassword_confirm().equals(userEntity.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
	}

}
