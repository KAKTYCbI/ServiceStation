package sjc.sample.app.repository.entity.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sjc.sample.app.repository.entity.ReviewEntity;

public class ReviewValidator implements Validator {

	@Override
	public boolean supports(Class<?> param) {
		
		return ReviewEntity.class.equals(param);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "whom", "whom.required", "Заполните поля"); 
		
	}

}
