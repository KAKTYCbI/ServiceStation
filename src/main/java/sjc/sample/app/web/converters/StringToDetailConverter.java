package sjc.sample.app.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import sjc.example.domain.model.Detail;
import sjc.example.domain.model.Service;
import sjc.example.domain.model.Sto;
import sjc.example.domain.service.ClientService;

@Component
public class StringToDetailConverter implements Converter<String, Detail>{

	@Autowired
	private ClientService clientService;

	
    @Override
    public Detail convert(String name) {
        return clientService.getDetailByName(name);
    }
}
