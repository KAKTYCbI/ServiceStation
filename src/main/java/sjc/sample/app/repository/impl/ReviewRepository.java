package sjc.sample.app.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sjc.example.domain.model.Mechanic;
import sjc.example.domain.model.Review;
import sjc.sample.app.repository.dao.ReviewDao;
import sjc.sample.app.repository.entity.ApplicationEntity;
import sjc.sample.app.repository.entity.ClientEntity;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.entity.ReviewEntity;
import sjc.sample.app.repository.hibernate.AbstractHibernateDao;

@Repository
public class ReviewRepository extends
AbstractHibernateDao<ReviewEntity, Long> implements ReviewDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ReviewEntity> getReviewByMechanic(MechanicEntity mechanic) {
			Criteria criteria = getSession().createCriteria(ReviewEntity.class).add(
					Restrictions.eq("mechanic", mechanic)).addOrder(Order.desc("id"));
			return (List<ReviewEntity>) criteria.list();
		
	}

}
