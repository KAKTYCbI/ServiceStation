package sjc.sample.app.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import sjc.example.domain.model.UserPrincipal;
import sjc.example.domain.service.UserService;
 
@Component
public class StringToUserPrincipalConverter implements Converter<String, UserPrincipal> {
 
    @Autowired
	private UserService userService;
     
    @Override
    public UserPrincipal convert(String userId) {
        return userService.getUserByID(new Long(userId));
    }
 
}