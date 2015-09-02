package sjc.sample.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
import sjc.sample.app.repository.dao.SalaryDao;
import sjc.sample.app.repository.dao.ServiceDao;
import sjc.sample.app.repository.dao.StatusDao;
import sjc.sample.app.repository.dao.StoDao;
import sjc.sample.app.repository.entity.ApplicationDetailEntity;
import sjc.sample.app.repository.entity.ApplicationEntity;
import sjc.sample.app.repository.entity.ClientEntity;
import sjc.sample.app.repository.entity.DetailEntity;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.entity.RentEntity;
import sjc.sample.app.repository.entity.SalaryEntity;
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
import sjc.example.domain.model.Report;
import sjc.example.domain.model.Salary;
import sjc.example.domain.model.Status;
import sjc.example.domain.model.Sto;
import sjc.example.domain.model.UserPrincipal;
import sjc.example.domain.service.DirectorService;
import sjc.example.domain.service.ReportService;


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
	private SalaryDao salaryRepository;
	
	@Autowired
	private ServiceDao serviceRepository;
	
	@Autowired
	private StatusDao statusRepository;
	
	@Autowired
	private RentDao rentRepository;
	
	@Autowired
	private DetailDao detailRepository;
	
	@Autowired
	private ReportService reportService;
	
	@Autowired
	private ModelClassMap modelClassMap;
	
	private Mapper getMapper() {
		return DozerBeanMapperSingletonWrapper.getInstance();
	}
	
	@Override
	public List<Application> getApplication(Integer first, Integer max) {
		List<Application> application = new ArrayList<Application>();
		List<ApplicationEntity> ApplicationEntities = applicationRepository.getAllApplication(first, max);
		for(ApplicationEntity ApplicationEntity : ApplicationEntities) {
			application.add(getMapper().map(ApplicationEntity, Application.class));
		}
		return application;
	}

	@Override
	public List<ApplicationDetail> getApplicationDetail(Integer first,Integer max) {
		List<ApplicationDetail> applicationDetail = new ArrayList<ApplicationDetail>();
		List<ApplicationDetailEntity> applicationDetailEntities = applicationDetailRepository.getAllApplicationDetailToPage(first, max);
		for(ApplicationDetailEntity ApplicationDetailEntity : applicationDetailEntities) {
			applicationDetail.add(getMapper().map(ApplicationDetailEntity, ApplicationDetail.class));
		}
		return applicationDetail;
	}

	@Override
	public List<Mechanic> getMechanicsToPage(Integer first,Integer max) {
		List<Mechanic> mechanic = new ArrayList<Mechanic>();
		List<MechanicEntity> mechanicEntities = mechanicRepository.getAllMechanicToPage(first, max);
		for(MechanicEntity MechanicEntity : mechanicEntities) {
			mechanic.add(getMapper().map(MechanicEntity, Mechanic.class));
		}
		return mechanic;
	}

	@Override
	public List<Mechanic> getMechanicsOnSto(Sto sto, Integer first, Integer max) {
		List<Mechanic> mechanic = new ArrayList<Mechanic>();
		List<MechanicEntity> mechanicEntities = mechanicRepository.findByStoToPage(((getMapper().map(sto,StoEntity.class))), first, max);
		for(MechanicEntity MechanicEntity : mechanicEntities) {
			mechanic.add(getMapper().map(MechanicEntity, Mechanic.class));
		}
		return mechanic;
	}

	@Override
	public List<Sto> getStoToPage(Integer first, Integer max) {
		List<Sto> sto = new ArrayList<Sto>();
		List<StoEntity> stoEntities = stoRepository.getAllStoToPage(first, max);
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
	public List<Application> getApplicationByStatus(Status status, Integer first, Integer max) {
		List<Application> application = new ArrayList<Application>();
		List<ApplicationEntity> applicationEntities = applicationRepository.getApplicationByStatus(((getMapper().map(status,StatusEntity.class))), first, max);
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
	@Override
	public void addSto(Sto sto) {
	    
		stoRepository.saveOrUpdate((getMapper().map(sto, StoEntity.class)));
		
	}
	
	@Override
	public void addSalary(Salary salary) {
		salaryRepository.save((getMapper().map(salary, SalaryEntity.class)));
		
	}

	@Override
	public Number getSizeAllApplication() {
		return applicationRepository.getAllSizeApplication();
	}

	@Override
	public Number getSizeAllApplicationDetail() {
		
		return applicationDetailRepository.getSizeApplicationDetail();
	}

	@Override
	public Number getSizeAllMechanic() {
		
		return mechanicRepository.getSizeAllMechanic();
	}

	@Override
	public Number getSizeMechanicOnSto(Sto sto) {
	
		
		return mechanicRepository.getSizeMechanicBySto((getMapper().map( sto ,StoEntity.class)));
	}

	@Override
	public Number getSizeAllSto() {
		
		return stoRepository.getSizeAllSto();
	}

	@Override
	public Number getSizeApplicationByStatus(Status status) {
		
		return applicationRepository.getSizeApplicationByStatus((getMapper().map(status,StatusEntity.class)));
	}

	@Override
	public List<Mechanic> getMechanics() {
		
		List<Mechanic> mechanic = new ArrayList<Mechanic>();
		List<MechanicEntity> mechanicEntities = mechanicRepository.getAllMechanic();
		for(MechanicEntity MechanicEntity : mechanicEntities) {
			mechanic.add(getMapper().map(MechanicEntity, Mechanic.class));
		}
		return mechanic;
	}

	@Override
	public List<Sto> getSto() {
		List<Sto> sto = new ArrayList<Sto>();
		List<StoEntity> stoEntities = stoRepository.getAllSto();
		for(StoEntity StoEntity : stoEntities) {
			sto.add(getMapper().map(StoEntity, Sto.class));
		}
		return sto;
	}

	@Override
	public Report getreportSto(Sto sto, Date dateStart, Date dateFinish) {
		Report report = new Report();
		List<Application> applications = reportService.getListStoApplicationToDate(sto, dateStart, dateFinish);
		
		List<Mechanic> mechanics = sto.getMechanics();
		List<Rent> rents = reportService.getListSTORent(sto, dateStart, dateFinish);
		Long applicationPrice = 0l;
		Float salaryPrice = (float)0;
		Long rentPrice = 0l;
		Long detailPrice = 0l;
		if (applications != null)
		{
		for(Application application:applications)
		{
			if (application.getPrice()!=null){
			applicationPrice+=application.getPrice();
			}
			List<Detail> details = application.getDetails();
			if (application.getDetails()!=null)
			{
			for(Detail detail:details)
			{
				detailPrice +=detail.getPrice();
			}
		    }
		}
		}
		List<Salary> salarys1 = new ArrayList<Salary>(); 
		if (mechanics!=null)
		{
		for(Mechanic mechanic:mechanics)
		{
			List<Salary> salarys = reportService.getListMechanicSalary(mechanic, dateStart, dateFinish);
            salarys1.addAll(salarys); 
		}
		}
		if (salarys1 != null)
		{
		for(Salary salary: salarys1)
		{
			salaryPrice +=salary.getSumma();
		}
		}
		if(rents != null)
		{
		for(Rent rent:rents)
		{
			rentPrice+=rent.getPrice();
		}
		
		}
		Long expenses = salaryPrice.longValue()+rentPrice+detailPrice;
		
		Long profit = applicationPrice - expenses;
		
		report.setApplicationPrice(applicationPrice);
		report.setDetailPrice(detailPrice);
		report.setExpenses(expenses);
		report.setProfit(profit);
		report.setRentPrice(rentPrice);
		report.setSalaryPrice(salaryPrice);
		
		return report;
	}

	@Override
	public Report getreportAll(Date dateStart, Date dateFinish) {
		List<Application> applications = reportService.getListApplicationToDate(dateStart, dateFinish);
		List<Salary> salarys = reportService.getListSalary(dateStart, dateFinish);
		List<Rent> rents = reportService.getlostRent(dateStart, dateFinish);
		Report report = new Report();
		Long applicationPrice = 0l;
		Float salaryPrice = (float)0;
		Long rentPrice = 0l;
		Long detailPrice = 0l;
		if (applications != null)
		{
		for(Application application:applications)
		{
			if (application.getPrice()!=null){
			applicationPrice+=application.getPrice();
			}
			List<Detail> details = application.getDetails();
			if (application.getDetails()!=null)
			{
			for(Detail detail:details)
			{
				detailPrice +=detail.getPrice();
			}
		    }
		}
		}
		if (salarys != null)
		{
		for(Salary salary: salarys)
		{
			salaryPrice +=salary.getSumma();
		}
		}
		if(rents != null)
		{
		for(Rent rent:rents)
		{
			rentPrice+=rent.getPrice();
		}
		
		}
		Long expenses = salaryPrice.longValue()+rentPrice+detailPrice;
		
		Long profit = applicationPrice - expenses;
		
		report.setApplicationPrice(applicationPrice);
		report.setDetailPrice(detailPrice);
		report.setExpenses(expenses);
		report.setProfit(profit);
		report.setRentPrice(rentPrice);
		report.setSalaryPrice(salaryPrice);
		
		return report;
	}
		
	
	

}
