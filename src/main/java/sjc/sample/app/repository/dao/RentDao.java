package sjc.sample.app.repository.dao;

import java.util.Date;
import java.util.List;

import sjc.sample.app.repository.base.GenericDao;
import sjc.sample.app.repository.entity.RentEntity;
import sjc.sample.app.repository.entity.StoEntity;

public interface RentDao extends GenericDao<RentEntity, Long>{
	
	 List<RentEntity> findByRentToDate(StoEntity sto, Date dateStart, Date dateFinish);

}
