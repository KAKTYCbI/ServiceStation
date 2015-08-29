package sjc.sample.app.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sjc.sample.app.repository.dao.ServiceDao;
import sjc.sample.app.repository.entity.ServiceEntity;
import sjc.sample.app.repository.entity.StoEntity;
import sjc.sample.app.repository.hibernate.AbstractHibernateDao;

@Repository
public class ServiceRepository extends
AbstractHibernateDao<ServiceEntity, Long> implements ServiceDao{

	@Override
	public ServiceEntity getServiceByName(String name) {
		Criteria cr = getSession().createCriteria(ServiceEntity.class,
				"service").add(Restrictions.eq("name", name));
		return (ServiceEntity) cr.uniqueResult();
	}

}
