package sjc.sample.app.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import sjc.example.domain.model.Mechanic;
import sjc.example.domain.service.DirectorService;

public class StringToMechanicConverter implements Converter<String, Mechanic> {

	@Autowired
	private DirectorService directorService;

	
    @Override
    public Mechanic convert(String name) {
        return directorService.getMechanicByName(name);
    }
}
