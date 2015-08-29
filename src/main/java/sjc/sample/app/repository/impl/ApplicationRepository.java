package sjc.sample.app.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sjc.sample.app.repository.dao.ApplicationDao;
import sjc.sample.app.repository.entity.ApplicationEntity;
import sjc.sample.app.repository.entity.ClientEntity;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.entity.StatusEntity;
import sjc.sample.app.repository.entity.StoEntity;
import sjc.sample.app.repository.hibernate.AbstractHibernateDao;

@Repository
public class ApplicationRepository extends
AbstractHibernateDao<ApplicationEntity, Long> implements ApplicationDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<ApplicationEntity> findByClient(ClientEntity client) {
		Criteria criteria = getSession().createCriteria(ApplicationEntity.class).add(
				Restrictions.eq("client", client));
		return (List<ApplicationEntity>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ApplicationEntity> findByMechanic(MechanicEntity mechanic) {
		Criteria criteria = getSession().createCriteria(ApplicationEntity.class).add(
				Restrictions.eq("mechanic", mechanic));
		return (List<ApplicationEntity>) criteria.list();
	}

	@Override
	public ApplicationEntity getApplicationByID(Long applicationId) {
		Criteria cr = getSession().createCriteria(ApplicationEntity.class,
				"application").add(Restrictions.eq("id", applicationId));
		return (ApplicationEntity) cr.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ApplicationEntity> findByStoToDate(StoEntity sto, Date dateStart,
			Date dateFinish) {
		Criteria criteria = getSession().createCriteria(ApplicationEntity.class).add(
				Restrictions.eq("sto", sto)).add(
						Restrictions.between("dateCompletion", dateStart, dateFinish));
		return (List<ApplicationEntity>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ApplicationEntity> findByMechanicToDate(MechanicEntity mechanic,
			Date dateStart, Date dateFinish) {
		Criteria criteria = getSession().createCriteria(ApplicationEntity.class).add(
				Restrictions.eq("mechanic", mechanic)).add(
						Restrictions.between("dateCompletion", dateStart, dateFinish));
		return (List<ApplicationEntity>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ApplicationEntity> getApplicationByStatus(StatusEntity status) {
		Criteria criteria = getSession().createCriteria(ApplicationEntity.class).add(
				Restrictions.eq("status", status));
		return (List<ApplicationEntity>) criteria.list();
	}


}
