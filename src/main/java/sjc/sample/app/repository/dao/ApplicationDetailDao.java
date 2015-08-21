package sjc.sample.app.repository.dao;

import java.util.List;
import sjc.sample.app.repository.base.GenericDao;
import sjc.sample.app.repository.entity.ApplicationDetailEntity;
import sjc.sample.app.repository.entity.MechanicEntity;



public interface ApplicationDetailDao extends GenericDao<ApplicationDetailEntity, Long>{
	
	List<ApplicationDetailEntity> findByMechanic(MechanicEntity mechanic);
}
