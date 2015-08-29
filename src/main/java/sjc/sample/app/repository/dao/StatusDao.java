package sjc.sample.app.repository.dao;

import sjc.sample.app.repository.base.GenericDao;
import sjc.sample.app.repository.entity.ServiceEntity;
import sjc.sample.app.repository.entity.StatusEntity;

public interface StatusDao extends GenericDao<StatusEntity, Long>{
	
	StatusEntity getStatusByName(String name);

}
