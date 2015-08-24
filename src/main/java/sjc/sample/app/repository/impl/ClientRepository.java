package sjc.sample.app.repository.impl;

import org.springframework.stereotype.Repository;

import sjc.sample.app.repository.dao.ClientDao;
import sjc.sample.app.repository.entity.ClientEntity;
import sjc.sample.app.repository.hibernate.AbstractHibernateDao;

@Repository
public class ClientRepository extends
AbstractHibernateDao<ClientEntity, Long> implements ClientDao{

}
