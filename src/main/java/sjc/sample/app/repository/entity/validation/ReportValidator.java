package sjc.sample.app.repository.entity.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sjc.example.domain.model.Report;

public class ReportValidator implements Validator {

	@Override
	public boolean supports(Class<?> param) {
		
		return Report.class.equals(param);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateStart", "dateStart.required", "dateStart is required"); 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateFinish", "dateFinish.required", "dateFinish is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "whom", "О ком.required", "Выберете значение");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sto", "sto.required", "Выберете значение");
		
	}

}
