package sjc.sample.app.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import sjc.example.domain.model.Client;
import sjc.example.domain.service.ClientService;
 
@Component
public class StringToClientConverter implements Converter<String, Client> {
 
    @Autowired
	private ClientService clientService;

     
    @Override
    public Client convert(String clientId) {
        return clientService.getCilentById(new Long(clientId));
    }
 
}