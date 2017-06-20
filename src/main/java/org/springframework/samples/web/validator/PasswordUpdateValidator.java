package org.springframework.samples.web.validator;

import org.springframework.samples.web.command.AccountCommand;
import org.springframework.samples.web.command.PasswordCommand;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PasswordUpdateValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AccountCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PasswordCommand pwd = (PasswordCommand) target;
		
		//null check
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwdCurrent", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwdNew", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwdNewConfirm", "required");
		
		//length check
		if(pwd.getPwdNew().getBytes().length > 20 || pwd.getPwdNew().getBytes().length < 6) 
			errors.rejectValue("pwdNew", "pwdLength");
		
		//새로운 비밀번호와 비밀번호 확인이 같은지 Check
		if(!pwd.getPwdNew().equals(pwd.getPwdNewConfirm()))
			errors.rejectValue("pwdNewConfirm", "invalidPwdConfirm");
		
		//현재 사용자의 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 Check
		if(!pwd.getPwd().equals(pwd.getPwdCurrent()))
			errors.rejectValue("pwdCurrent", "invalidCurrentPwd");
		
	}
	
}
