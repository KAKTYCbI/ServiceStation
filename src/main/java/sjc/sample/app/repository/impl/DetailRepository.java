package sjc.sample.app.repository.impl;

import org.springframework.stereotype.Repository;

import sjc.sample.app.repository.dao.DetailDao;
import sjc.sample.app.repository.entity.DetailEntity;
import sjc.sample.app.repository.hibernate.AbstractHibernateDao;

@Repository
public class DetailRepository extends
AbstractHibernateDao<DetailEntity, Long> implements DetailDao{

}
