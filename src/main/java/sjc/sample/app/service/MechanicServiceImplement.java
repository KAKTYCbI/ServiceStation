package sjc.sample.app.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.sample.app.repository.dao.ApplicationDao;
import sjc.sample.app.repository.dao.ApplicationDetailDao;
import sjc.sample.app.repository.dao.MessageDao;
import sjc.sample.app.repository.dao.ReviewDao;
import sjc.sample.app.repository.entity.ApplicationDetailEntity;
import sjc.sample.app.repository.entity.ApplicationEntity;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.entity.MessageEntity;
import sjc.sample.app.repository.entity.ReviewEntity;
import sjc.sample.app.repository.entity.StatusEntity;
import sjc.sample.app.repository.entity.StoEntity;
import sjc.sample.app.repository.entity.map.ModelClassMap;
import sjc.example.domain.model.Application;
import sjc.example.domain.model.ApplicationDetail;
import sjc.example.domain.model.Mechanic;
import sjc.example.domain.model.Message;
import sjc.example.domain.model.Review;
import sjc.example.domain.model.Sto;
import sjc.example.domain.service.DirectorService;
import sjc.example.domain.service.MechanicService;

@Service()
@Transactional
public class MechanicServiceImplement implements MechanicService{

	@Autowired
	private ApplicationDao applicationRepository;
	
	@Autowired
	private MessageDao messageRepository;
	
	@Autowired
	private ApplicationDetailDao applicationDetailRepository;
	
	@Autowired
	private ReviewDao reviewRepository;
	
	@Autowired
	private ModelClassMap modelClassMap;
	
	@Autowired
	private DirectorService directorService;
	
	private Mapper getMapper() {
		return DozerBeanMapperSingletonWrapper.getInstance();
	}
	
	@Override
	public List<Application> getCurrentApplication(Mechanic mechanic, Integer first, Integer max) {
	 
		List<Application> application = new ArrayList<Application>();
		List<ApplicationEntity> applicationEntities = applicationRepository.findByMechanic(((getMapper().map(mechanic,MechanicEntity.class))), first, max);
		for(ApplicationEntity ApplicationEntity : applicationEntities) {
			application.add(getMapper().map(ApplicationEntity, Application.class));
		}
		return application;
	}

	@Override
	public List<ApplicationDetail> getApplicationDetailByMechanic(Mechanic mechanic, Integer first, Integer max) {
		List<ApplicationDetail> applicationDetail = new ArrayList<ApplicationDetail>();
		List<ApplicationDetailEntity> applicationDetailEntities = applicationDetailRepository.findByMechanicToPage(((getMapper().map(mechanic,MechanicEntity.class))), first, max);
		for(ApplicationDetailEntity ApplicationDetailEntity : applicationDetailEntities) {
			applicationDetail.add(getMapper().map(ApplicationDetailEntity, ApplicationDetail.class));
		}
		return applicationDetail;
	}

	@Override
	public void updateApplication(Application application) {
		applicationRepository.update((getMapper().map(application, ApplicationEntity.class)));
	
	}

	@Override
	public Application getApplicationById(Long Id) {
		ApplicationEntity applicationEntity = applicationRepository.getApplicationByID(Id);
		Application applicationModel = null;
		if (applicationEntity != null) {
			applicationModel = (Application) getMapper().map(applicationEntity,
					modelClassMap.getModelClass(applicationEntity.getClass()));
		}
		return applicationModel;
	}

	@Override
	public void orderDetail(ApplicationDetail applicationDetail) {

		applicationDetailRepository.save((getMapper().map(applicationDetail, ApplicationDetailEntity.class)));

	}

	@Override
	public void notification(Message message) {
		messageRepository.save((getMapper().map(message, MessageEntity.class)));

		
	}

	@Override
	public List<Review> getReviewByMechanic(Mechanic mechanic, Integer first, Integer max) {
		
		List<Review> review = new ArrayList<Review>();
		List<ReviewEntity> reviewEntities = reviewRepository.getReviewByMechanicToPage(((getMapper().map(mechanic,MechanicEntity.class))), first, max);
		for(ReviewEntity ReviewEntity : reviewEntities) {
			review.add(getMapper().map(ReviewEntity, Review.class));
		}
		return review;
	}

	@Override
	public List<Review> getReviewBySto(Sto sto, Integer first, Integer max) {
		List<Review> review = new ArrayList<Review>();
		List<ReviewEntity> reviewEntities = reviewRepository.getReviewByStoToPage((getMapper().map(sto,StoEntity.class)), first, max);
		for(ReviewEntity ReviewEntity : reviewEntities) {
			review.add(getMapper().map(ReviewEntity, Review.class));
		}
		return review;

	}

	@Override
	public Number getSizeApplicationByMechanic(Mechanic mechanic) {
		// TODO Auto-generated method stub
		return applicationRepository.getSizeApplicationByMechanic((getMapper().map(mechanic,MechanicEntity.class)));

	}

	@Override
	public Number getSizeApplicationDeatilByMechanic(Mechanic mechanic) {
		// TODO Auto-generated method stub
		return applicationDetailRepository.getSizeApplicationDetailByMechanic((getMapper().map(mechanic,MechanicEntity.class)));

	}

	@Override
	public Number getSizeReviewByMechanic(Mechanic mechanic) {
		// TODO Auto-generated method stub
		return reviewRepository.getSizeReviewByMechanic((getMapper().map(mechanic,MechanicEntity.class)));

	}

	@Override
	public Number getSizeReviewBySto(Sto sto) {
		// TODO Auto-generated method stub
		return reviewRepository.getSizeReviewBySto((getMapper().map(sto,StoEntity.class)));
	}

	
	

}
