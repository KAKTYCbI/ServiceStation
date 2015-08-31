package sjc.sample.app.repository.dao;

import java.util.List;

import sjc.example.domain.model.Mechanic;
import sjc.example.domain.model.Review;
import sjc.sample.app.repository.base.GenericDao;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.entity.ReviewEntity;
import sjc.sample.app.repository.entity.StoEntity;

public interface ReviewDao extends GenericDao<ReviewEntity, Long>{
	
	List<ReviewEntity> getReviewByMechanic(MechanicEntity mechanic);
	
	List<ReviewEntity> getReviewBySto(StoEntity sto);

}
