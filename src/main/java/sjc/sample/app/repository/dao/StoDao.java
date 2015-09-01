package sjc.sample.app.repository.dao;

import java.util.List;

import sjc.sample.app.repository.base.GenericDao;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.entity.StoEntity;

public interface StoDao extends GenericDao<StoEntity, Long>{
	
	List<StoEntity> getAllStoToPage(Integer first,Integer max);
	
	List<StoEntity> getAllSto();
	
	Number getSizeAllSto();
	
	StoEntity findByName(String name);
	
	StoEntity getStoById(Long id);

}
