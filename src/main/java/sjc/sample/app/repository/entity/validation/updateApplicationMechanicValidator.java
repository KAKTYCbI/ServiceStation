package sjc.sample.app.repository.entity.validation;

import org.springframework.validation.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import sjc.sample.app.repository.entity.ApplicationEntity;

public class updateApplicationMechanicValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> param) {
		return ApplicationEntity.class.equals(param);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "status", "status.required", "status is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "details", "details.required", "details is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateCompletion", "dateCompletion.required", "dateCompletion");
	}
}