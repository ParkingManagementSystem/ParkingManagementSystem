package org.springframework.samples.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.command.AccountCommand;
import org.springframework.samples.web.service.AccountService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AccountValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AccountCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AccountCommand account = (AccountCommand) target;
		//null check
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "required");
		try {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthday", "required");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//length check
		if (account.getId() != null && !account.getId().trim().isEmpty()) {
			if(account.getId().getBytes().length > 20)
				errors.rejectValue("id", "maxLength.20");
		}
		if (account.getPwd() != null && !account.getPwd().trim().isEmpty()) {
			if(account.getPwd().getBytes().length > 20 || account.getPwd().getBytes().length < 6) 
				errors.rejectValue("pwd", "pwdLength");
		}
		if (account.getName() != null || !account.getName().trim().isEmpty()) {
			if(account.getName().getBytes().length > 20)
				errors.rejectValue("name", "maxLength.20");
		}
		
	}
	
}
