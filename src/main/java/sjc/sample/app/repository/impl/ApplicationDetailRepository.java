package sjc.sample.app.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sjc.sample.app.repository.dao.ApplicationDetailDao;
import sjc.sample.app.repository.entity.ApplicationDetailEntity;
import sjc.sample.app.repository.entity.ApplicationEntity;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.hibernate.AbstractHibernateDao;

@Repository
public class ApplicationDetailRepository extends
AbstractHibernateDao<ApplicationDetailEntity, Long> implements ApplicationDetailDao{

	@Override
	public ApplicationDetailEntity getApplicationDetailById(Long Id) {
		Criteria cr = getSession().createCriteria(ApplicationDetailEntity.class).add(
				Restrictions.eq("applicationDetailId", Id));
		return (ApplicationDetailEntity) cr.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ApplicationDetailEntity> findByMechanicToPage(
			MechanicEntity mechanic, Integer first, Integer max) {
		Criteria criteria = getSession().createCriteria(ApplicationDetailEntity.class).add(
				Restrictions.eq("mechanic", mechanic)).addOrder(Order.desc("id")).setFirstResult(first).setMaxResults(max);
		return (List<ApplicationDetailEntity>) criteria.list();
	}

	@Override
	public Number getSizeApplicationDetailByMechanic(MechanicEntity mechanic) {
		Criteria criteria = getSession().createCriteria(ApplicationDetailEntity.class).add(
				Restrictions.eq("mechanic", mechanic)).setProjection(Projections.rowCount());
		return (Number) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ApplicationDetailEntity> getAllApplicationDetailToPage(Integer first, Integer max) {
		Criteria criteria = getSession().createCriteria(ApplicationDetailEntity.class)
				.addOrder(Order.desc("applicationDetailId")).setFirstResult(first).setMaxResults(max);
		return (List<ApplicationDetailEntity>) criteria.list();
	}

	@Override
	public Number getSizeApplicationDetail() {
		Criteria criteria = getSession().createCriteria(ApplicationDetailEntity.class).setProjection(Projections.rowCount());
		return (Number) criteria.uniqueResult();
	}


}
