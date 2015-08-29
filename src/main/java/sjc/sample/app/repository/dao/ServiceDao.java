package sjc.sample.app.repository.dao;

import sjc.sample.app.repository.base.GenericDao;
import sjc.sample.app.repository.entity.ServiceEntity;

public interface ServiceDao extends GenericDao<ServiceEntity, Long>{

	ServiceEntity getServiceByName(String name);
}
