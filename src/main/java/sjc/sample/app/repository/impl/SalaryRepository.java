package sjc.sample.app.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;




import org.springframework.stereotype.Repository;

import sjc.sample.app.repository.dao.SalaryDao;
import sjc.sample.app.repository.entity.DirectorEntity;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.entity.SalaryEntity;
import sjc.sample.app.repository.entity.StoEntity;
import sjc.sample.app.repository.hibernate.AbstractHibernateDao;

@Repository
public class SalaryRepository extends
AbstractHibernateDao<SalaryEntity, Long> implements SalaryDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<SalaryEntity> findBySalaryToDate(Date dateStart, Date dateFinish) {
		Criteria criteria = getSession().createCriteria(SalaryEntity.class).add(
				Restrictions.between("date", dateStart, dateFinish));
		return (List<SalaryEntity>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SalaryEntity> findByMechanicSalaryToDate(MechanicEntity mechanic,
			Date dateStart, Date dateFinish) {
		Criteria criteria = getSession().createCriteria(SalaryEntity.class).add(
				Restrictions.eq("mechanic", mechanic)).add(
				Restrictions.between("date", dateStart, dateFinish));
		return (List<SalaryEntity>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SalaryEntity> findByDirectorSalaryToDate(DirectorEntity director,
			Date dateStart, Date dateFinish) {
		Criteria criteria = getSession().createCriteria(SalaryEntity.class).add(
				Restrictions.eq("director", director)).add(
				Restrictions.between("date", dateStart, dateFinish));
		return (List<SalaryEntity>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SalaryEntity> findBySalaryToDate(StoEntity sto, Date dateStart,
			Date dateFinish) {
		Criteria criteria = getSession().createCriteria(SalaryEntity.class).add(
				Restrictions.eq("sto", sto)).add(
				Restrictions.between("date", dateStart, dateFinish));
		return (List<SalaryEntity>) criteria.list();
	}

}
