package sjc.sample.app.repository.entity.map;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import sjc.example.domain.model.Client;
import sjc.example.domain.model.Director;
import sjc.example.domain.model.Mechanic;
import sjc.sample.app.repository.entity.ClientEntity;
import sjc.sample.app.repository.entity.DirectorEntity;
import sjc.sample.app.repository.entity.MechanicEntity;

@Component
public class ModelClassMap {
	
	private Map<Class<?>, Class<?>> modelClassMappings;

	public ModelClassMap() {
		modelClassMappings = new HashMap<Class<?>, Class<?>>();

		modelClassMappings.put(ClientEntity.class, Client.class);
		modelClassMappings.put(Client.class, ClientEntity.class);

		modelClassMappings.put(MechanicEntity.class, Mechanic.class);
		modelClassMappings.put(Mechanic.class, MechanicEntity.class);
		
		modelClassMappings.put(DirectorEntity.class, Director.class);
		modelClassMappings.put(Director.class, DirectorEntity.class);

	}

	public Class<?> getModelClass(Class<?> entityClass) {

		if (modelClassMappings.containsKey(entityClass)) {
			return modelClassMappings.get(entityClass);
		} else {
			throw new RuntimeException("Unsupported mapping for "
					+ entityClass.getCanonicalName());
		}
	}	

}
