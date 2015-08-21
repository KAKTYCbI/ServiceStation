package sjc.sample.app.repository.impl;

import org.springframework.stereotype.Repository;

import sjc.sample.app.repository.dao.ServiceDao;
import sjc.sample.app.repository.entity.ServiceEntity;
import sjc.sample.app.repository.hibernate.AbstractHibernateDao;

@Repository
public class ServiceRepository extends
AbstractHibernateDao<ServiceEntity, Long> implements ServiceDao{

}
