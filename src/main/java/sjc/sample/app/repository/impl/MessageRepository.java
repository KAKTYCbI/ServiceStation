package sjc.sample.app.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
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

}
