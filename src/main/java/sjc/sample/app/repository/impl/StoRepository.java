package sjc.sample.app.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sjc.sample.app.repository.dao.StoDao;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.entity.StoEntity;
import sjc.sample.app.repository.entity.UserPrincipalEntity;
import sjc.sample.app.repository.hibernate.AbstractHibernateDao;

@Repository
public class StoRepository extends
AbstractHibernateDao<StoEntity, Long> implements StoDao{

	@Override
	public StoEntity findByName(String name) {
		Criteria cr = getSession().createCriteria(StoEntity.class,
				"sto").add(Restrictions.eq("name", name));
		return (StoEntity) cr.uniqueResult();
	
	}

	@Override
	public StoEntity getStoById(Long id) {
		Criteria cr = getSession().createCriteria(StoEntity.class,
				"users").add(Restrictions.eq("stoId", id));
		return (StoEntity) cr.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StoEntity> getAllStoToPage(Integer first, Integer max) {
		Criteria criteria = getSession().createCriteria(StoEntity.class).setFirstResult(first).setMaxResults(max);
		return (List<StoEntity>) criteria.list();
	}

	@Override
	public Number getSizeAllSto() {
		Criteria criteria = getSession().createCriteria(StoEntity.class).setProjection(Projections.rowCount());
		return (Number) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StoEntity> getAllSto() {
		Criteria criteria = getSession().createCriteria(StoEntity.class);
		return (List<StoEntity>) criteria.list();
	}


}
