package sjc.sample.app.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import sjc.example.domain.model.Service;
import sjc.example.domain.model.Sto;
import sjc.example.domain.service.ClientService;
import sjc.example.domain.service.DirectorService;

@Component
public class StringToServiceConverter implements Converter<String, Service> {

	@Autowired
	private ClientService clientService;

	
    @Override
    public Service convert(String name) {
        return clientService.getServiceByName(name);
    }
}
