package sjc.sample.app.repository.entity.validation;

import org.springframework.validation.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import sjc.sample.app.repository.entity.ApplicationEntity;

public class addApplicationValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> param) {
		return ApplicationEntity.class.equals(param);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sto", "sto.required", "sto is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "services", "services.required", "выберете поле");
		
	}

}