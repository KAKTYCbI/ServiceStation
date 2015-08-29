package sjc.sample.app.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import sjc.example.domain.model.Service;
import sjc.example.domain.model.Status;
import sjc.example.domain.service.ClientService;

public class StringToStatusConverter implements Converter<String, Status> {

	@Autowired
	private ClientService clientService;

	
    @Override
    public Status convert(String status) {
        return clientService.getStatusByName(status);
    }
}

