package sjc.sample.app.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sjc.sample.app.repository.dao.ApplicationDetailDao;
import sjc.sample.app.repository.entity.ApplicationDetailEntity;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.hibernate.AbstractHibernateDao;

@Repository
public class ApplicationDetailRepository extends
AbstractHibernateDao<ApplicationDetailEntity, Long> implements ApplicationDetailDao{
	@SuppressWarnings("unchecked")
	@Override
	public List<ApplicationDetailEntity> findByMechanic(MechanicEntity mechanic) {
		Criteria criteria = getSession().createCriteria(ApplicationDetailEntity.class).add(
				Restrictions.eq("mechanic", mechanic));
		return (List<ApplicationDetailEntity>) criteria.list();
	}


}
