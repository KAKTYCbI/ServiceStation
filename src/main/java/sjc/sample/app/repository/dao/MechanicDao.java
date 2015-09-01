package sjc.sample.app.repository.dao;

import java.util.List;

import sjc.sample.app.repository.base.GenericDao;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.entity.StoEntity;

public interface MechanicDao extends GenericDao<MechanicEntity, Long> {
	
	List<MechanicEntity> getAllMechanicToPage(Integer first, Integer max);
	
	List<MechanicEntity> getAllMechanic();
	
	Number getSizeAllMechanic();
	
	List<MechanicEntity> findByStoToPage(StoEntity sto, Integer first, Integer max);
	
	Number getSizeMechanicBySto(StoEntity sto);
	
	MechanicEntity getMechanicById(Long id);
	
	MechanicEntity getMechanicByName(String name);

}
