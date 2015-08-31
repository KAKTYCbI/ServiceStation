package sjc.sample.app.repository.dao;

import java.util.List;

import sjc.sample.app.repository.base.GenericDao;
import sjc.sample.app.repository.entity.ClientEntity;
import sjc.sample.app.repository.entity.MessageEntity;

public interface MessageDao extends GenericDao<MessageEntity, Long>{

	List<MessageEntity> findByClient(ClientEntity client);
	
	List<MessageEntity> findByClientToPage(ClientEntity client, Integer first, Integer max);
}
