package sjc.sample.app.repository.impl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;


import org.springframework.stereotype.Repository;

import sjc.sample.app.repository.dao.MechanicDao;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.entity.StoEntity;
import sjc.sample.app.repository.entity.UserPrincipalEntity;
import sjc.sample.app.repository.hibernate.AbstractHibernateDao;

@Repository
public class MechanicRepository extends
AbstractHibernateDao<MechanicEntity, Long> implements MechanicDao{

	@SuppressWarnings("unchecked")
	@Override
	public List <MechanicEntity> findBySto(StoEntity sto) {
		Criteria criteria = getSession().createCriteria(MechanicEntity.class).add(
				Restrictions.eq("sto", sto));
		return (List<MechanicEntity>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public MechanicEntity getMechanicById(Long id) {
		Criteria cr = getSession().createCriteria(UserPrincipalEntity.class,
				"users").add(Restrictions.eq("user_id", id));
		return (MechanicEntity) cr.uniqueResult();

	}
	
	
	
	
	

}
