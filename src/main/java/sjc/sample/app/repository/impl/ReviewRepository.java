package sjc.sample.app.repository.impl;

import org.springframework.stereotype.Repository;

import sjc.sample.app.repository.dao.ReviewDao;
import sjc.sample.app.repository.entity.ReviewEntity;
import sjc.sample.app.repository.hibernate.AbstractHibernateDao;

@Repository
public class ReviewRepository extends
AbstractHibernateDao<ReviewEntity, Long> implements ReviewDao {

}
