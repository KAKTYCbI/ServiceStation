package sjc.sample.app.repository.entity.map;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import sjc.example.domain.model.Application;
import sjc.example.domain.model.ApplicationDetail;
import sjc.example.domain.model.Client;
import sjc.example.domain.model.Detail;
import sjc.example.domain.model.Director;
import sjc.example.domain.model.Mechanic;
import sjc.example.domain.model.Review;
import sjc.example.domain.model.Service;
import sjc.example.domain.model.Status;
import sjc.example.domain.model.Sto;
import sjc.example.domain.model.UserPrincipal;
import sjc.sample.app.repository.entity.ApplicationDetailEntity;
import sjc.sample.app.repository.entity.ApplicationEntity;
import sjc.sample.app.repository.entity.ClientEntity;
import sjc.sample.app.repository.entity.DetailEntity;
import sjc.sample.app.repository.entity.DirectorEntity;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.entity.ReviewEntity;
import sjc.sample.app.repository.entity.ServiceEntity;
import sjc.sample.app.repository.entity.StatusEntity;
import sjc.sample.app.repository.entity.StoEntity;
import sjc.sample.app.repository.entity.UserPrincipalEntity;

@Component
public class ModelClassMap {
	
	private Map<Class<?>, Class<?>> modelClassMappings;

	public ModelClassMap() {
		modelClassMappings = new HashMap<Class<?>, Class<?>>();

		modelClassMappings.put(UserPrincipalEntity.class, UserPrincipal.class);
		modelClassMappings.put(UserPrincipal.class, UserPrincipalEntity.class);
		
		modelClassMappings.put(ClientEntity.class, Client.class);
		modelClassMappings.put(Client.class, ClientEntity.class);

		modelClassMappings.put(MechanicEntity.class, Mechanic.class);
		modelClassMappings.put(Mechanic.class, MechanicEntity.class);
		
		modelClassMappings.put(DirectorEntity.class, Director.class);
		modelClassMappings.put(Director.class, DirectorEntity.class);

		modelClassMappings.put(ReviewEntity.class, Review.class);
		modelClassMappings.put(Review.class, ReviewEntity.class);
		
		modelClassMappings.put(StoEntity.class, Sto.class);
		modelClassMappings.put(Sto.class, StoEntity.class);
		
		modelClassMappings.put(ServiceEntity.class, Service.class);
		modelClassMappings.put(Service.class, ServiceEntity.class);
		
		modelClassMappings.put(DetailEntity.class, Detail.class);
		modelClassMappings.put(Detail.class, DetailEntity.class);
		
		modelClassMappings.put(StatusEntity.class, Status.class);
		modelClassMappings.put(Status.class, StatusEntity.class);
		
		modelClassMappings.put(ApplicationEntity.class, Application.class);
		modelClassMappings.put(Application.class, ApplicationEntity.class);
		
		
		modelClassMappings.put(ApplicationDetailEntity.class, ApplicationDetail.class);
		modelClassMappings.put(ApplicationDetail.class, ApplicationDetailEntity.class);
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
