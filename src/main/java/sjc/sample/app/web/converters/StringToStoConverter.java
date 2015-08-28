package sjc.sample.app.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import sjc.example.domain.model.Client;
import sjc.example.domain.model.Sto;
import sjc.example.domain.service.ClientService;
import sjc.example.domain.service.DirectorService;
 
@Component
public class StringToStoConverter implements Converter<String, Sto> {
 
    @Autowired
	private DirectorService directorService;

	
    @Override
    public Sto convert(String name) {
        return directorService.getStoByName(name);
    }
 
}