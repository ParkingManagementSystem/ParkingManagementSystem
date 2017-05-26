package org.springframework.samples.web.validator;

import org.springframework.samples.web.command.SignInCommand;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SignInValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return SignInCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		//null check
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");
		
	}

}
