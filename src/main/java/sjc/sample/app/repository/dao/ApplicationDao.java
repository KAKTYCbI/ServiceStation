package sjc.sample.app.repository.dao;

import java.util.Date;
import java.util.List;
import sjc.sample.app.repository.base.GenericDao;
import sjc.sample.app.repository.entity.ApplicationEntity;
import sjc.sample.app.repository.entity.ClientEntity;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.entity.StoEntity;

public interface ApplicationDao extends GenericDao<ApplicationEntity, Long> {
	
	List<ApplicationEntity> findByClient(ClientEntity client);
	
	List<ApplicationEntity> findByMechanic(MechanicEntity mechanic);
	
	List<ApplicationEntity> findByStoToDate(StoEntity sto,Date dateStart, Date dateFinish);
	
	List<ApplicationEntity> findByMechanicToDate(MechanicEntity mechanic, Date dateStart, Date dateFinish);
	
	ApplicationEntity getApplicationByID(Long applicationId);

}
