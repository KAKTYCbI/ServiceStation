package sjc.sample.app.repository.dao;

import java.util.List;

import sjc.sample.app.repository.base.GenericDao;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.entity.StoEntity;

public interface MechanicDao extends GenericDao<MechanicEntity, Long> {
	
	List<MechanicEntity> findBySto(StoEntity sto);
	
	MechanicEntity getMechanicById(Long id);

}
