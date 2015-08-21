package sjc.sample.app.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.sample.app.repository.dao.ApplicationDao;
import sjc.sample.app.repository.dao.MessageDao;
import sjc.sample.app.repository.dao.ReviewDao;
import sjc.sample.app.repository.dao.StoDao;
import sjc.sample.app.repository.entity.ApplicationEntity;
import sjc.sample.app.repository.entity.ClientEntity;
import sjc.sample.app.repository.entity.MessageEntity;
import sjc.sample.app.repository.entity.ReviewEntity;
import sjc.sample.app.repository.entity.StoEntity;
import sjc.example.domain.model.Application;
import sjc.example.domain.model.Client;
import sjc.example.domain.model.Message;
import sjc.example.domain.model.Review;
import sjc.example.domain.model.Sto;
import sjc.example.domain.service.ClientService;

@Service()
@Transactional
public class ClientServiceImplement implements ClientService{

	@Autowired
	private ApplicationDao applicationRepository;
	
	@Autowired
	private ReviewDao reviewRepository;
	
	@Autowired
	private StoDao stoRepository;
	
	@Autowired
	private MessageDao messageRepository;
	
	
	private Mapper getMapper() {
		return DozerBeanMapperSingletonWrapper.getInstance();
	}
	
	@Override
	public void addOrUpdateApplication(Application application) {
		
		//applicationRepository.saveOrUpdate((getMapper().map(application, ApplicationEntity.class)));

	}

	@Override
	public List<Message> getMessageByClient(Client client) {
		
		List<Message> message = new ArrayList<Message>();
		List<MessageEntity> messageEntities = messageRepository.findByClient((getMapper().map(client,ClientEntity.class)));
		for(MessageEntity MessageEntity : messageEntities) {
			message.add(getMapper().map(MessageEntity, Message.class));
		}
		return message;
		
	}

	@Override
	public void addReview(Review review) {
	
		reviewRepository.save((getMapper().map(review, ReviewEntity.class)));

	}


	@Override
	public List<Sto> getAllSto() {
		List<Sto> sto = new ArrayList<Sto>();
		List<StoEntity> stoEntities = stoRepository.findAll();
		for(StoEntity StoEntity : stoEntities) {
			sto.add(getMapper().map(StoEntity, Sto.class));
		}
		return sto;
	}

	@Override
	public List<Application> getApplication(Client client) {
		List<Application> application = new ArrayList<Application>();
		List<ApplicationEntity> applicationEntities = applicationRepository.findByClient((getMapper().map(client,ClientEntity.class)));
		for(ApplicationEntity ApplicationEntity : applicationEntities) {
			application.add(getMapper().map(ApplicationEntity, Application.class));
		}
		return application;
	}

}
