package sjc.example.domain.service;


import java.util.List;

import sjc.example.domain.model.Application;
import sjc.example.domain.model.ApplicationDetail;
import sjc.example.domain.model.Detail;
import sjc.example.domain.model.Mechanic;
import sjc.example.domain.model.Rent;
import sjc.example.domain.model.Service;
import sjc.example.domain.model.Status;
import sjc.example.domain.model.Sto;


public interface DirectorService {
	
	//����� ��������� ������  ���� ������
	List<Application> getApplication();
	
	//����� ��������� ������  ���� ������ �� ������
	List<ApplicationDetail> getApplicationDetail();
	
	//����� ��������� ������  ���� ���������
	List<Mechanic> getMechanics();
	
	//����� ��������� ������  ���� ��������� �� ���������� ���
	List<Mechanic> getMechanicsOnSto(Sto sto);
	
	//����� ��������� ������  ���� ���
    List<Sto> getSto();
    
    List<Status> getStatus();
    //����� ��������� ������
    void addDetail(Detail detail);
    
    //����� ��������� �������� ��� ��������� ��� ������
    void saveOrUpdateMechanic(Mechanic mechanic);
    
    //����� ��������� ������ �� ���������� ���
    void addRent(Rent rent);
	
    //����� ��������� ������
    void addService(Service service);
    
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
    
    List<Application> getApplicationByStatus(Status status);
    
    Mechanic getMechanicByName(String name);
}
