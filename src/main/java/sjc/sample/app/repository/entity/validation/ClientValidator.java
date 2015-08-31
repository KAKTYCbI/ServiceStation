package sjc.sample.app.repository.entity.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sjc.sample.app.repository.entity.ClientEntity;


public class ClientValidator implements Validator {
	 
    @Override
    public boolean supports(Class<?> paramClass) {
        return ClientEntity.class.equals(paramClass);
    }
 
    @Override
    public void validate(Object obj, Errors errors) {
         
    	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required", "name is required");    	
    	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required", "email is required");  
    	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact", "contatc.required", "contatc is required");  
    	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required", "password is required");  
    	

         
    }
}