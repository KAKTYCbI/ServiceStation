package sjc.sample.app.repository.dao;

import java.util.List;
import sjc.sample.app.repository.base.GenericDao;
import sjc.sample.app.repository.entity.ApplicationDetailEntity;
import sjc.sample.app.repository.entity.MechanicEntity;



public interface ApplicationDetailDao extends GenericDao<ApplicationDetailEntity, Long>{
	
	List<ApplicationDetailEntity> findByMechanicToPage(MechanicEntity mechanic, Integer first, Integer max);
	
	Number getSizeApplicationDetailByMechanic(MechanicEntity mechanic);
	
	List<ApplicationDetailEntity> getAllApplicationDetailToPage(Integer first, Integer max);
	
	Number getSizeApplicationDetail();
	
	ApplicationDetailEntity getApplicationDetailById(Long Id);
}
