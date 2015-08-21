package sjc.sample.app.repository.dao;

import sjc.sample.app.repository.base.GenericDao;
import sjc.sample.app.repository.entity.UserPrincipalEntity;

public interface UserDao extends GenericDao<UserPrincipalEntity, Long> {

	UserPrincipalEntity getUser(String login, String password);

	UserPrincipalEntity getUserByID(Long userId);

	UserPrincipalEntity getUserByName(String name);

}
