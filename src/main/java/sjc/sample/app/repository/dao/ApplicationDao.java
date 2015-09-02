package sjc.sample.app.repository.dao;

import java.util.Date;
import java.util.List;

import sjc.sample.app.repository.base.GenericDao;
import sjc.sample.app.repository.entity.ApplicationEntity;
import sjc.sample.app.repository.entity.ClientEntity;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.entity.StatusEntity;
import sjc.sample.app.repository.entity.StoEntity;

public interface ApplicationDao extends GenericDao<ApplicationEntity, Long> {
	
	List<ApplicationEntity> findByClientToPage(ClientEntity client, Integer first, Integer max);
	
	Number getSizeApplicationByClient(ClientEntity client);
	
	List<ApplicationEntity> getAllApplication( Integer first, Integer max);
	
	Number getAllSizeApplication();
	
	List<ApplicationEntity> findByMechanic(MechanicEntity mechanic,Integer first, Integer max);
	
	Number getSizeApplicationByMechanic(MechanicEntity client);
	
	List<ApplicationEntity> findByStoToDate(StoEntity sto,Date dateStart, Date dateFinish);
	
	List<ApplicationEntity> findToDate(Date dateStart, Date dateFinish);
	
	List<ApplicationEntity> findByMechanicToDate(MechanicEntity mechanic, Date dateStart, Date dateFinish);
	
	ApplicationEntity getApplicationByID(Long applicationId);
	
	List<ApplicationEntity> getApplicationByStatus(StatusEntity status, Integer first, Integer max);
	
	Number getSizeApplicationByStatus(StatusEntity client);
	

}
