package sjc.sample.app.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import sjc.example.domain.model.Application;
import sjc.example.domain.service.MechanicService;

public class StringToApplicationConverter implements Converter<String, Application> {

	@Autowired
	private MechanicService mechanicService;

	
    @Override
    public Application convert(String id) {
        return mechanicService.getApplicationById(new Long(id));
    }
}
