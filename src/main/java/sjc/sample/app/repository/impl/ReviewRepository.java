package sjc.sample.app.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sjc.example.domain.model.Mechanic;
import sjc.example.domain.model.Review;
import sjc.sample.app.repository.dao.ReviewDao;
import sjc.sample.app.repository.entity.ApplicationEntity;
import sjc.sample.app.repository.entity.ClientEntity;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.entity.MessageEntity;
import sjc.sample.app.repository.entity.ReviewEntity;
import sjc.sample.app.repository.entity.StoEntity;
import sjc.sample.app.repository.hibernate.AbstractHibernateDao;

@Repository
public class ReviewRepository extends
AbstractHibernateDao<ReviewEntity, Long> implements ReviewDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ReviewEntity> getReviewByMechanicToPage(MechanicEntity mechanic, Integer first, Integer max) {
			Criteria criteria = getSession().createCriteria(ReviewEntity.class).add(
					Restrictions.eq("mechanic", mechanic)).addOrder(Order.desc("id")).setFirstResult(first).setMaxResults(max);
			return (List<ReviewEntity>) criteria.list();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReviewEntity> getReviewByStoToPage(StoEntity sto, Integer first, Integer max) {
			Criteria criteria = getSession().createCriteria(ReviewEntity.class).add(
					Restrictions.eq("sto", sto)).addOrder(Order.desc("id")).setFirstResult(first).setMaxResults(max);
			return (List<ReviewEntity>) criteria.list();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReviewEntity> getReviewToPage(Integer first, Integer mac) {
		Criteria criteria = getSession().createCriteria(ReviewEntity.class).addOrder(
				Order.desc("id")).setFirstResult(first).setMaxResults(mac);
		return (List<ReviewEntity>) criteria.list();
	}

	@Override
	public Number getSizeRiview() {
		Criteria criteria = getSession().createCriteria(ReviewEntity.class).setProjection(Projections.rowCount());
		return (Number) criteria.uniqueResult();
	}

	@Override
	public Number getSizeReviewByMechanic(MechanicEntity mechanic) {
		Criteria criteria = getSession().createCriteria(ReviewEntity.class).add(
				Restrictions.eq("mechanic", mechanic)).setProjection(Projections.rowCount());
		return (Number) criteria.uniqueResult();
	}

	@Override
	public Number getSizeReviewBySto(StoEntity sto) {
		Criteria criteria = getSession().createCriteria(ReviewEntity.class).add(
				Restrictions.eq("sto", sto)).setProjection(Projections.rowCount());
		return (Number) criteria.uniqueResult();
	}

}
