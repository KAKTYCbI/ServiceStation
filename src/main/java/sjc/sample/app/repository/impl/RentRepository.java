package sjc.sample.app.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import sjc.sample.app.repository.dao.RentDao;
import sjc.sample.app.repository.entity.RentEntity;
import sjc.sample.app.repository.entity.StoEntity;
import sjc.sample.app.repository.hibernate.AbstractHibernateDao;

@Repository
public class RentRepository extends
AbstractHibernateDao<RentEntity, Long> implements RentDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RentEntity> findByRentToDate(StoEntity sto, Date dateStart, Date dateFinish)
	{
		Criteria criteria = getSession().createCriteria(RentEntity.class).add(
				Restrictions.eq("sto", sto)).add(
				Restrictions.between("start", dateStart, dateFinish));
		return (List<RentEntity>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RentEntity> findByRentToDateAll(Date dateStart, Date dateFinish) {
		Criteria criteria = getSession().createCriteria(RentEntity.class).add(
				Restrictions.between("start", dateStart, dateFinish));
		return (List<RentEntity>) criteria.list();
	}

}
