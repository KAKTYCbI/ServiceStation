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
import sjc.sample.app.repository.dao.DetailDao;
import sjc.sample.app.repository.dao.MechanicDao;
import sjc.sample.app.repository.dao.RentDao;
import sjc.sample.app.repository.dao.ServiceDao;
import sjc.sample.app.repository.dao.StatusDao;
import sjc.sample.app.repository.dao.StoDao;
import sjc.sample.app.repository.entity.ApplicationDetailEntity;
import sjc.sample.app.repository.entity.ApplicationEntity;
import sjc.sample.app.repository.entity.DetailEntity;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.entity.RentEntity;
import sjc.sample.app.repository.entity.ServiceEntity;
import sjc.sample.app.repository.entity.StatusEntity;
import sjc.sample.app.repository.entity.StoEntity;
import sjc.sample.app.repository.entity.UserPrincipalEntity;
import sjc.sample.app.repository.entity.map.ModelClassMap;
import sjc.example.domain.model.Application;
import sjc.example.domain.model.ApplicationDetail;
import sjc.example.domain.model.Detail;
import sjc.example.domain.model.Mechanic;
import sjc.example.domain.model.Rent;
import sjc.example.domain.model.Status;
import sjc.example.domain.model.Sto;
import sjc.example.domain.model.UserPrincipal;
import sjc.example.domain.service.DirectorService;

@Service()
@Transactional
public class DirectorServiceImplement implements DirectorService{

	@Autowired
	private ApplicationDao applicationRepository;
	
	@Autowired
	private ApplicationDetailDao applicationDetailRepository;
	
	@Autowired
	private MechanicDao mechanicRepository;

	@Autowired
	private StoDao stoRepository;
	
	@Autowired
	private ServiceDao serviceRepository;
	
	@Autowired
	private StatusDao statusRepository;
	
	@Autowired
	private RentDao rentRepository;
	
	@Autowired
	private DetailDao detailRepository;
	
	
	@Autowired
	private ModelClassMap modelClassMap;
	
	private Mapper getMapper() {
		return DozerBeanMapperSingletonWrapper.getInstance();
	}
	@Override
	public List<Application> getApplication() {
		List<Application> application = new ArrayList<Application>();
		List<ApplicationEntity> ApplicationEntities = applicationRepository.findAll();
		for(ApplicationEntity ApplicationEntity : ApplicationEntities) {
			application.add(getMapper().map(ApplicationEntity, Application.class));
		}
		return application;
	}

	@Override
	public List<ApplicationDetail> getApplicationDetail() {
		List<ApplicationDetail> applicationDetail = new ArrayList<ApplicationDetail>();
		List<ApplicationDetailEntity> applicationDetailEntities = applicationDetailRepository.getAllApplicationDetail();
		for(ApplicationDetailEntity ApplicationDetailEntity : applicationDetailEntities) {
			applicationDetail.add(getMapper().map(ApplicationDetailEntity, ApplicationDetail.class));
		}
		return applicationDetail;
	}

	@Override
	public List<Mechanic> getMechanics() {
		List<Mechanic> mechanic = new ArrayList<Mechanic>();
		List<MechanicEntity> mechanicEntities = mechanicRepository.findAll();
		for(MechanicEntity MechanicEntity : mechanicEntities) {
			mechanic.add(getMapper().map(MechanicEntity, Mechanic.class));
		}
		return mechanic;
	}

	@Override
	public List<Mechanic> getMechanicsOnSto(Sto sto) {
		List<Mechanic> mechanic = new ArrayList<Mechanic>();
		List<MechanicEntity> mechanicEntities = mechanicRepository.findBySto((getMapper().map(sto,StoEntity.class)));
		for(MechanicEntity MechanicEntity : mechanicEntities) {
			mechanic.add(getMapper().map(MechanicEntity, Mechanic.class));
		}
		return mechanic;
	}

	@Override
	public List<Sto> getSto() {
		List<Sto> sto = new ArrayList<Sto>();
		List<StoEntity> stoEntities = stoRepository.findAll();
		for(StoEntity StoEntity : stoEntities) {
			sto.add(getMapper().map(StoEntity, Sto.class));
		}
		return sto;
	}

	@Override
	public void addDetail(Detail detail) {
		detailRepository.save((getMapper().map(detail, DetailEntity.class)));
		
	}

	@Override
	public void saveOrUpdateMechanic(Mechanic mechanic) {
		mechanicRepository.saveOrUpdate((getMapper().map(mechanic, MechanicEntity.class)));
		
	}

	@Override
	public void addRent(Rent rent) {
		
		rentRepository.save((getMapper().map(rent, RentEntity.class)));
	}

	@Override
	public void addService(sjc.example.domain.model.Service service) {
	
		serviceRepository.save((getMapper().map(service, ServiceEntity.class)));
	}

	@Override
	public void deleteMechanic(Mechanic mechanic) {
	      mechanicRepository.delete((getMapper().map(mechanic, MechanicEntity.class)));
		
	}


	@Override
	public void saveApplicationDetail(ApplicationDetail applicationDetail) {
		applicationDetailRepository.saveOrUpdate((getMapper().map(applicationDetail, ApplicationDetailEntity.class)));

		
	}

	@Override
	public void updateApplication(Application application) {
		  
		applicationRepository.update((getMapper().map(application, ApplicationEntity.class)));
		
	}
	@Override
	public Sto getStoByName(String name) {
		StoEntity stoEntity = stoRepository.findByName(name);
		Sto stoModel = null;
		if (stoEntity != null) {
			stoModel = (Sto) getMapper().map(stoEntity,
					modelClassMap.getModelClass(stoEntity.getClass()));
		}
		return stoModel;
	}
	
	@Override
	public Mechanic getMechanicById(Long id) {
		MechanicEntity mechanicEntity = mechanicRepository.getMechanicById(id);
		Mechanic mechanicModel = null;
		if (mechanicEntity != null) {
			mechanicModel = (Mechanic) getMapper().map(mechanicEntity,
					modelClassMap.getModelClass(mechanicEntity.getClass()));
		}
		return mechanicModel;
	}
	@Override
	public Sto getStoById(Long id) {
		StoEntity stoEntity = stoRepository.getStoById(id);
		Sto stoModel = null;
		if (stoEntity != null) {
			stoModel = (Sto) getMapper().map(stoEntity,
					modelClassMap.getModelClass(stoEntity.getClass()));
		}
		return stoModel;
	}
	@Override
	public List<Application> getApplicationByStatus(Status status) {
		List<Application> application = new ArrayList<Application>();
		List<ApplicationEntity> applicationEntities = applicationRepository.getApplicationByStatus((getMapper().map(status,StatusEntity.class)));
		for(ApplicationEntity ApplicationEntity : applicationEntities) {
			application.add(getMapper().map(ApplicationEntity, Application.class));
		}
		return application;
	}
	@Override
	public Mechanic getMechanicByName(String name) {
		MechanicEntity mechanicEntity = mechanicRepository.getMechanicByName(name);
		Mechanic mechanicModel = null;
		if (mechanicEntity != null) {
			mechanicModel = (Mechanic) getMapper().map(mechanicEntity,
					modelClassMap.getModelClass(mechanicEntity.getClass()));
		}
		return mechanicModel;
	}
	@Override
	public List<Status> getStatus() {
		List<Status> status = new ArrayList<Status>();
		List<StatusEntity> StatusEntities = statusRepository.findAll();
		for(StatusEntity StatusEntity : StatusEntities) {
			status.add(getMapper().map(StatusEntity, Status.class));
		}
		return status;
	}
	@Override
	public ApplicationDetail getApplicationDetailById(Long id) {
		ApplicationDetailEntity applicationDetailEntity = applicationDetailRepository.getApplicationDetailById(id);
		ApplicationDetail applicationDetailModel = null;
		if (applicationDetailEntity != null) {
			applicationDetailModel = (ApplicationDetail) getMapper().map(applicationDetailEntity,
					modelClassMap.getModelClass(applicationDetailEntity.getClass()));
		}
		return applicationDetailModel;
	}
	
	
	
	
	
	

}
