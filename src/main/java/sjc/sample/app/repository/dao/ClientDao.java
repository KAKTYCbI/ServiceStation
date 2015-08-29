package sjc.sample.app.repository.dao;

import sjc.sample.app.repository.base.GenericDao;
import sjc.sample.app.repository.entity.ClientEntity;

public interface ClientDao extends GenericDao<ClientEntity, Long>{
	
	ClientEntity getClientByID(Long id); 

}
