package sjc.sample.app.repository.entity.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sjc.sample.app.repository.entity.ClientEntity;

@Component("clientValidator")
public class ClientValidator implements Validator {
	 
    @Override
    public boolean supports(Class<?> paramClass) {
        return ClientEntity.class.equals(paramClass);
    }
 
    @Override
    public void validate(Object obj, Errors errors) {
         
    	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clientName", "clientName.required");    	
    	//ClientEntity client = (ClientEntity) obj;
    	
    	//... do validation
         
    }
}