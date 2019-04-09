package com.rf.rftool.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import com.rf.rftool.model.Escalations;

@Validated
public class EscalationValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Escalations.class.equals(clazz) ;
	}
	@Autowired
	@Override
	public void validate(Object target, Errors errors) {
		
		Escalations escalations = (Escalations) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "siteid", "siteid can not be blank");
		
	}

}
