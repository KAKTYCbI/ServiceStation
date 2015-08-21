package sjc.sample.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sjc.sample.app.repository.dao.ApplicationDao;
import sjc.sample.app.repository.dao.RentDao;
import sjc.sample.app.repository.dao.SalaryDao;
import sjc.sample.app.repository.entity.ApplicationEntity;
import sjc.sample.app.repository.entity.DirectorEntity;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.entity.RentEntity;
import sjc.sample.app.repository.entity.SalaryEntity;
import sjc.sample.app.repository.entity.StoEntity;
import sjc.sample.app.repository.entity.map.ModelClassMap;
import sjc.example.domain.model.Application;
import sjc.example.domain.model.Director;
import sjc.example.domain.model.Mechanic;
import sjc.example.domain.model.Rent;
import sjc.example.domain.model.Salary;
import sjc.example.domain.model.Sto;
import sjc.example.domain.service.ReportService;

@Service()
@Transactional
public class ReportServiceImplement implements ReportService{

	@Autowired
	private ApplicationDao applicationRepository;
	
	@Autowired
	private RentDao rentRepository;
	
	@Autowired
	private SalaryDao salaryRepository;
	
	@Autowired
	private ModelClassMap modelClassMap;
	
	private Mapper getMapper() {
		return DozerBeanMapperSingletonWrapper.getInstance();
	}
	
	@Override
	public List<Salary> getListSalary(Date dateStart, Date dateFinish) {
		List<Salary> salary = new ArrayList<Salary>();
		List<SalaryEntity> salaryEntities = salaryRepository.findBySalaryToDate(dateStart, dateFinish);
		for(SalaryEntity SalaryEntity : salaryEntities) {
			salary.add(getMapper().map(SalaryEntity, Salary.class));
		}
		return salary;
	}

	@Override
	public List<Salary> getListDirectorSalary(Director director,
			Date dateStart, Date dateFinish) {
		List<Salary> salary = new ArrayList<Salary>();
		List<SalaryEntity> salaryEntities = salaryRepository.findByDirectorSalaryToDate((getMapper().map(director,DirectorEntity.class)), dateStart, dateFinish);
		for(SalaryEntity SalaryEntity : salaryEntities) {
			salary.add(getMapper().map(SalaryEntity, Salary.class));
		}
		return salary;
	}

	@Override
	public List<Rent> getListSTORent(Sto sto, Date dateStart, Date dateFinish) {
		List<Rent> rent = new ArrayList<Rent>();
		List<RentEntity> rentEntities = rentRepository.findByRentToDate((getMapper().map(sto,StoEntity.class)), dateStart, dateFinish);
		for(RentEntity RentEntity : rentEntities) {
			rent.add(getMapper().map(RentEntity, Rent.class));
		}
		return rent;
	}

	@Override
	public List<Salary> getListMechanicSalary(Mechanic mechanic,
			Date dateStart, Date dateFinish) {
		List<Salary> salary = new ArrayList<Salary>();
		List<SalaryEntity> salaryEntities = salaryRepository.findByMechanicSalaryToDate((getMapper().map(mechanic,MechanicEntity.class)), dateStart, dateFinish);
		for(SalaryEntity SalaryEntity : salaryEntities) {
			salary.add(getMapper().map(SalaryEntity, Salary.class));
		}
		return salary;
	}

	@Override
	public List<Application> getListStoApplicationToDate(Sto sto,
			Date dateStart, Date dateFinish) {
		List<Application> application = new ArrayList<Application>();
		List<ApplicationEntity> applicationEntities = applicationRepository.findByStoToDate((getMapper().map(sto,StoEntity.class)), dateStart, dateFinish);
		for(ApplicationEntity ApplicationEntity : applicationEntities) {
			application.add(getMapper().map(ApplicationEntity, Application.class));
		}
		return application;
	}

	@Override
	public List<Application> getListMechanicApplicationToDate(
			Mechanic mechanic, Date dateStart, Date dateFinish) {
		List<Application> application = new ArrayList<Application>();
		List<ApplicationEntity> applicationEntities = applicationRepository.findByMechanicToDate((getMapper().map(mechanic,MechanicEntity.class)), dateStart, dateFinish);
		for(ApplicationEntity ApplicationEntity : applicationEntities) {
			application.add(getMapper().map(ApplicationEntity, Application.class));
		}
		return application;
	}

}
