package sjc.sample.app.repository.dao;

import sjc.sample.app.repository.base.GenericDao;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.entity.StoEntity;

public interface StoDao extends GenericDao<StoEntity, Long>{
	
	StoEntity findByName(String name);
	
	StoEntity getStoById(Long id);

}
