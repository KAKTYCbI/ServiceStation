package sjc.sample.app.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sjc.sample.app.repository.dao.MessageDao;
import sjc.sample.app.repository.entity.ClientEntity;
import sjc.sample.app.repository.entity.MessageEntity;
import sjc.sample.app.repository.hibernate.AbstractHibernateDao;

@Repository
public class MessageRepository extends
AbstractHibernateDao<MessageEntity, Long> implements MessageDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<MessageEntity> findByClient(ClientEntity client) {
		Criteria criteria = getSession().createCriteria(MessageEntity.class).add(
				Restrictions.eq("client", client)).addOrder(Order.desc("id"));
		return (List<MessageEntity>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MessageEntity> findByClientToPage(ClientEntity client,
			Integer first, Integer max) {
		  Criteria criteria = getSession().createCriteria(MessageEntity.class).add(
				Restrictions.eq("client", client)).addOrder(Order.desc("id")).setFirstResult(first).setMaxResults(max);
		return (List<MessageEntity>) criteria.list();
	}

	@Override
	public Number sizeMessagesbyClient(ClientEntity client) {
		Criteria criteria = getSession().createCriteria(MessageEntity.class).add(
				Restrictions.eq("client", client)).setProjection(Projections.rowCount());
		return (Number) criteria.uniqueResult();
	}

}
