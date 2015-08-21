package sjc.sample.app.repository.dao;

import java.util.Date;
import java.util.List;
import sjc.sample.app.repository.base.GenericDao;
import sjc.sample.app.repository.entity.DirectorEntity;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.entity.SalaryEntity;

public interface SalaryDao extends GenericDao<SalaryEntity, Long> {

	List<SalaryEntity> findBySalaryToDate(Date dateStart, Date dateFinish);
	
	List<SalaryEntity> findByMechanicSalaryToDate(MechanicEntity mechanic, Date dateStart, Date dateFinish);
	
	List<SalaryEntity> findByDirectorSalaryToDate(DirectorEntity director, Date dateStart, Date dateFinish);
}
