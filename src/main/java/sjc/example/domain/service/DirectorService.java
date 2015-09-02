package sjc.example.domain.service;


import java.util.Date;
import java.util.List;

import sjc.example.domain.model.Application;
import sjc.example.domain.model.ApplicationDetail;
import sjc.example.domain.model.Detail;
import sjc.example.domain.model.Mechanic;
import sjc.example.domain.model.Rent;
import sjc.example.domain.model.Report;
import sjc.example.domain.model.Salary;
import sjc.example.domain.model.Service;
import sjc.example.domain.model.Status;
import sjc.example.domain.model.Sto;


public interface DirectorService {
	
	//метод возращает список  всех заявок
	List<Application> getApplication(Integer first, Integer max);
	
	Number getSizeAllApplication();
	
	Report getreportSto(Sto sto, Date dateStart, Date dateFinish);
	
	Report getreportAll(Date dateStart, Date dateFinish);
	
	//метод возращает список  всех заявок на детали
	List<ApplicationDetail> getApplicationDetail(Integer first, Integer max);
	
	Number getSizeAllApplicationDetail();
	
	//метод возращает список  всех Механиков
	List<Mechanic> getMechanicsToPage(Integer first, Integer max);
	
	List<Mechanic> getMechanics();
	
    Number getSizeAllMechanic();
	
	//метод возращает список  всех Механиков на конкретном сто
	List<Mechanic> getMechanicsOnSto(Sto sto, Integer first, Integer max);
	
	Number getSizeMechanicOnSto(Sto sto);
	//метод возращает список  всех СТО
    List<Sto> getStoToPage(Integer first, Integer max);
    
    List<Sto> getSto();
    
    Number getSizeAllSto();
    
    List<Status> getStatus();
    //метод дабавляет делать
    void addDetail(Detail detail);
    
    
    void addSalary(Salary salary);
    //метод дабавляет механика или обнавляет его данные
    void saveOrUpdateMechanic(Mechanic mechanic);
    
    //метод дабавляет аренду на конкретном сто
    void addRent(Rent rent);
	
    //метод дабавляет услугу
    void addService(Service service);
    
    void addSto(Sto sto);
    
    //метод удалет механика
    void deleteMechanic(Mechanic mechanic);
    
    //метод изменяет  заявку
    void updateApplication(Application application);
	
    //метод обнавлет(сохраняет) заявку на деталь
    void saveApplicationDetail(ApplicationDetail applicationDetail);

    ApplicationDetail getApplicationDetailById(Long id);
    
    Sto getStoByName(String name);
    
    Sto getStoById(Long id);
    
    Mechanic getMechanicById(Long id);
    
    List<Application> getApplicationByStatus(Status status, Integer first, Integer max);
    
    Number getSizeApplicationByStatus(Status status);
    
    Mechanic getMechanicByName(String name);
}
