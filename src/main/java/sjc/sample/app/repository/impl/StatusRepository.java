package sjc.sample.app.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import sjc.sample.app.repository.dao.StatusDao;
import sjc.sample.app.repository.entity.StatusEntity;
import sjc.sample.app.repository.hibernate.AbstractHibernateDao;

@Repository
public class StatusRepository extends
AbstractHibernateDao<StatusEntity, Long> implements StatusDao{

	@Override
	public StatusEntity getStatusByName(String name) {
		Criteria cr = getSession().createCriteria(StatusEntity.class,
				"status").add(Restrictions.eq("text", name));
		return (StatusEntity) cr.uniqueResult();
	}

}
