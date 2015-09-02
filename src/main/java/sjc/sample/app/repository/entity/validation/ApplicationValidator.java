package sjc.sample.app.repository.entity.validation;

import org.springframework.validation.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import sjc.sample.app.repository.entity.ApplicationEntity;

public class ApplicationValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> param) {
		return ApplicationEntity.class.equals(param);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mechanic", "mechanic.required", "mechanic is required"); 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "status", "status.required", "status is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateComlpetion", "dateComlpetion.required", "dateComlpetion is required");
		
	}

}
