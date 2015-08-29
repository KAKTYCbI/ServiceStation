package sjc.sample.app.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sjc.sample.app.repository.dao.ClientDao;
import sjc.sample.app.repository.entity.ClientEntity;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.hibernate.AbstractHibernateDao;

@Repository
public class ClientRepository extends
AbstractHibernateDao<ClientEntity, Long> implements ClientDao{

	@Override
	public ClientEntity getClientByID(Long id) {
		Criteria cr = getSession().createCriteria(ClientEntity.class).add(
				Restrictions.eq("userId", id));
		return (ClientEntity) cr.uniqueResult();
	}

}
