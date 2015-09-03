package sjc.sample.app.repository.entity.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sjc.example.domain.model.Review;
import sjc.sample.app.repository.entity.ReviewEntity;

public class ReviewValidator implements Validator {

	@Override
	public boolean supports(Class<?> param) {
		
		return Review.class.equals(param);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "whom", "whom.required", "whom is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text", "text.required", "rext is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rating", "rating.required", "rating is required");
		
	}

}
