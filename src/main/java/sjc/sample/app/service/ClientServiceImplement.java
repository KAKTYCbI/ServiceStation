package sjc.sample.app.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.sample.app.repository.dao.ApplicationDao;
import sjc.sample.app.repository.dao.ClientDao;
import sjc.sample.app.repository.dao.DetailDao;
import sjc.sample.app.repository.dao.MessageDao;
import sjc.sample.app.repository.dao.ReviewDao;
import sjc.sample.app.repository.dao.ServiceDao;
import sjc.sample.app.repository.dao.StatusDao;
import sjc.sample.app.repository.dao.StoDao;
import sjc.sample.app.repository.entity.ApplicationEntity;
import sjc.sample.app.repository.entity.ClientEntity;
import sjc.sample.app.repository.entity.DetailEntity;
import sjc.sample.app.repository.entity.MessageEntity;
import sjc.sample.app.repository.entity.ReviewEntity;
import sjc.sample.app.repository.entity.ServiceEntity;
import sjc.sample.app.repository.entity.StatusEntity;
import sjc.sample.app.repository.entity.StoEntity;
import sjc.sample.app.repository.entity.UserPrincipalEntity;
import sjc.sample.app.repository.entity.map.ModelClassMap;
import sjc.example.domain.model.Application;
import sjc.example.domain.model.Client;
import sjc.example.domain.model.Detail;
import sjc.example.domain.model.Message;
import sjc.example.domain.model.Review;
import sjc.example.domain.model.Status;
import sjc.example.domain.model.Sto;
import sjc.example.domain.model.UserPrincipal;
import sjc.example.domain.service.ClientService;

@Service()
@Transactional
public class ClientServiceImplement implements ClientService{

	@Autowired
	private ModelClassMap modelClassMap;
	
	@Autowired
	private ApplicationDao applicationRepository;
	
	@Autowired
	private ClientDao clientRepository;
	
	@Autowired
	private ReviewDao reviewRepository;
	
	@Autowired
	private StoDao stoRepository;
	
	@Autowired
	private ServiceDao serviceRepository;
	
	@Autowired
	private DetailDao detailRepository;
	
	
	@Autowired
	private StatusDao statusRepository;
	
	@Autowired
	private MessageDao messageRepository;
	
	
	private Mapper getMapper() {
		return DozerBeanMapperSingletonWrapper.getInstance();
	}
	
	@Override
	public void addOrUpdateApplication(Application application) {
		
		applicationRepository.saveOrUpdate((getMapper().map(application, ApplicationEntity.class)));

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

	@Override
	public void saveClient(Client client) {
		
		clientRepository.save(getMapper().map(client, ClientEntity.class));
	}

	@Override
	public Client getCilentById(Long id) {
		ClientEntity clientEntity = clientRepository.getClientByID(id);
		Client clientModel = null;
		if (clientEntity != null) {
			clientModel = (Client) getMapper().map(clientEntity,
					modelClassMap.getModelClass(clientEntity.getClass()));
		}
		return clientModel;
	}

	@Override
	public sjc.example.domain.model.Service getServiceByName(String name) {
		ServiceEntity serviceEntity = serviceRepository.getServiceByName(name);
		sjc.example.domain.model.Service serviceModel = null;
		if (serviceEntity != null) {
			serviceModel = (sjc.example.domain.model.Service) getMapper().map(serviceEntity,
					modelClassMap.getModelClass(serviceEntity.getClass()));
		}
		return serviceModel;
	}

	@Override
	public Detail getDetailByName(String name) {
		DetailEntity detailEntity = detailRepository.getDetailByName(name);
		Detail detailModel = null;
		if (detailEntity != null) {
			detailModel = (Detail) getMapper().map(detailEntity,
					modelClassMap.getModelClass(detailEntity.getClass()));
		}
		return detailModel;
	}

	@Override
	public List<sjc.example.domain.model.Service> getService() {
		List<sjc.example.domain.model.Service> service = new ArrayList<sjc.example.domain.model.Service>();
		List<ServiceEntity> serviceEntities = serviceRepository.findAll();
		for(ServiceEntity ServiceEntity : serviceEntities) {
			service.add(getMapper().map(ServiceEntity, sjc.example.domain.model.Service.class));
		}
		return service;
	}

	@Override
	public List<Detail> getDetail() {
		List<Detail> detail = new ArrayList<Detail>();
		List<DetailEntity> detailEntities = detailRepository.findAll();
		for(DetailEntity DetailEntity : detailEntities) {
			detail.add(getMapper().map(DetailEntity, Detail.class));
		}
		return detail;
	}

	@Override
	public Status getStatusByName(String name) {
		StatusEntity statusEntity = statusRepository.getStatusByName(name);
		Status statusModel = null;
		if (statusEntity != null) {
			statusModel = (Status) getMapper().map(statusEntity,
					modelClassMap.getModelClass(statusEntity.getClass()));
		}
		return statusModel;
	}

}
