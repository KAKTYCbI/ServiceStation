package sjc.sample.app.repository.impl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


import org.springframework.stereotype.Repository;

import sjc.sample.app.repository.dao.MechanicDao;
import sjc.sample.app.repository.entity.ApplicationEntity;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.entity.StoEntity;
import sjc.sample.app.repository.entity.UserPrincipalEntity;
import sjc.sample.app.repository.hibernate.AbstractHibernateDao;

@Repository
public class MechanicRepository extends
AbstractHibernateDao<MechanicEntity, Long> implements MechanicDao{

	@SuppressWarnings("unchecked")
	@Override
	public MechanicEntity getMechanicById(Long id) {
		Criteria cr = getSession().createCriteria(MechanicEntity.class).add(
				Restrictions.eq("userId", id));
		return (MechanicEntity) cr.uniqueResult();

	}

	@Override
	public MechanicEntity getMechanicByName(String name) {
		Criteria cr = getSession().createCriteria(MechanicEntity.class).add(
				Restrictions.eq("name", name));
		return (MechanicEntity) cr.uniqueResult();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MechanicEntity> getAllMechanicToPage(Integer first, Integer max) {
		Criteria criteria = getSession().createCriteria(MechanicEntity.class).setFirstResult(first).setMaxResults(max);
		return (List<MechanicEntity>) criteria.list();
	}

	@Override
	public Number getSizeAllMechanic() {
		Criteria criteria = getSession().createCriteria(MechanicEntity.class).setProjection(Projections.rowCount());
		return (Number) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MechanicEntity> findByStoToPage(StoEntity sto, Integer first,
			Integer max) {
		Criteria criteria = getSession().createCriteria(MechanicEntity.class).add(
				Restrictions.eq("sto", sto)).setFirstResult(first).setMaxResults(max);
		return (List<MechanicEntity>) criteria.list();
	}

	@Override
	public Number getSizeMechanicBySto(StoEntity sto) {
		Criteria criteria = getSession().createCriteria(MechanicEntity.class).add(
				Restrictions.eq("sto", sto)).setProjection(Projections.rowCount());
		return (Number) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MechanicEntity> getAllMechanic() {
		Criteria criteria = getSession().createCriteria(MechanicEntity.class);
		return (List<MechanicEntity>) criteria.list();
	}
	
	
	
	
	

}
