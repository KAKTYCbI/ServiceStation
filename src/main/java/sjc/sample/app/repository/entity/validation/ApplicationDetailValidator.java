package sjc.sample.app.repository.entity.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sjc.sample.app.repository.entity.ApplicationDetailEntity;

public class ApplicationDetailValidator implements Validator {

	@Override
	public boolean supports(Class<?> param) {
		return ApplicationDetailEntity.class.equals(param);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateDelivery", "date.required", "date is required"); 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "status", "status.required", "status is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required", "name is required"); 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "application", "application.required", "application is required"); 
		
	}

}
