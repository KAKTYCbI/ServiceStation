package sjc.sample.app.repository.entity.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sjc.sample.app.repository.entity.MechanicEntity;

public class MechanicValidator implements Validator{

	@Override
	public boolean supports(Class<?> param) {
		
		return MechanicEntity.class.equals(param);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required", "name is required"); 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required", "email is required");    	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact", "contact.required", "contact is required"); 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salary", "salary.required", "salary is required");    	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required", "password is required"); 				
		
	}

}
