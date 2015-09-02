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
	
	//����� ��������� ������  ���� ������
	List<Application> getApplication(Integer first, Integer max);
	
	Number getSizeAllApplication();
	
	Report getreportSto(Sto sto, Date dateStart, Date dateFinish);
	
	Report getreportAll(Date dateStart, Date dateFinish);
	
	//����� ��������� ������  ���� ������ �� ������
	List<ApplicationDetail> getApplicationDetail(Integer first, Integer max);
	
	Number getSizeAllApplicationDetail();
	
	//����� ��������� ������  ���� ���������
	List<Mechanic> getMechanicsToPage(Integer first, Integer max);
	
	List<Mechanic> getMechanics();
	
    Number getSizeAllMechanic();
	
	//����� ��������� ������  ���� ��������� �� ���������� ���
	List<Mechanic> getMechanicsOnSto(Sto sto, Integer first, Integer max);
	
	Number getSizeMechanicOnSto(Sto sto);
	//����� ��������� ������  ���� ���
    List<Sto> getStoToPage(Integer first, Integer max);
    
    List<Sto> getSto();
    
    Number getSizeAllSto();
    
    List<Status> getStatus();
    //����� ��������� ������
    void addDetail(Detail detail);
    
    
    void addSalary(Salary salary);
    //����� ��������� �������� ��� ��������� ��� ������
    void saveOrUpdateMechanic(Mechanic mechanic);
    
    //����� ��������� ������ �� ���������� ���
    void addRent(Rent rent);
	
    //����� ��������� ������
    void addService(Service service);
    
    void addSto(Sto sto);
    
    //����� ������ ��������
    void deleteMechanic(Mechanic mechanic);
    
    //����� ��������  ������
    void updateApplication(Application application);
	
    //����� ��������(���������) ������ �� ������
    void saveApplicationDetail(ApplicationDetail applicationDetail);

    ApplicationDetail getApplicationDetailById(Long id);
    
    Sto getStoByName(String name);
    
    Sto getStoById(Long id);
    
    Mechanic getMechanicById(Long id);
    
    List<Application> getApplicationByStatus(Status status, Integer first, Integer max);
    
    Number getSizeApplicationByStatus(Status status);
    
    Mechanic getMechanicByName(String name);
}
