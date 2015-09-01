package sjc.sample.app.repository.entity.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sjc.sample.app.repository.entity.StoEntity;

public class StoValidator implements Validator{

	@Override
	public boolean supports(Class<?> param) {
		return StoEntity.class.equals(param);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required", "name is required"); 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "price.required", "price is required");
		
	}

}
