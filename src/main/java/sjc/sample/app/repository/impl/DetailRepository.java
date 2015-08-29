package sjc.sample.app.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sjc.sample.app.repository.dao.DetailDao;
import sjc.sample.app.repository.entity.DetailEntity;
import sjc.sample.app.repository.entity.StoEntity;
import sjc.sample.app.repository.hibernate.AbstractHibernateDao;

@Repository
public class DetailRepository extends
AbstractHibernateDao<DetailEntity, Long> implements DetailDao{

	@Override
	public DetailEntity getDetailByName(String Name) {
		Criteria cr = getSession().createCriteria(DetailEntity.class,
				"detail").add(Restrictions.eq("name", Name));
		return (DetailEntity) cr.uniqueResult();
	}

}
