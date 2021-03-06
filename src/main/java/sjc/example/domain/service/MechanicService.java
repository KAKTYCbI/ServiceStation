package sjc.example.domain.service;
import java.util.List;

import sjc.example.domain.model.Application;
import sjc.example.domain.model.ApplicationDetail;
import sjc.example.domain.model.Mechanic;
import sjc.example.domain.model.Message;
import sjc.example.domain.model.Review;
import sjc.example.domain.model.Sto;

public interface MechanicService {

	 
	 // ����� ���������� ������ ������ ��������� ��������
	 List<Application> getCurrentApplication(Mechanic mechanic, Integer first, Integer max);
	 
	 Number getSizeApplicationByMechanic(Mechanic mechanic);
	 
	 //����� ��������� ������ ������ �� ������ � ������������� ��������
	 List<ApplicationDetail> getApplicationDetailByMechanic(Mechanic mechanic, Integer first, Integer max);
	 
	 Number getSizeApplicationDeatilByMechanic(Mechanic mechanic);
	 
	 //����� ��������� ������
	 void updateApplication(Application application);
	 
	 //��������� ������ �� Id
	 Application getApplicationById(Long Id);
	    
	 //����� ������� ������ �� ��������(��������)
	 void orderDetail(ApplicationDetail applicationDetail);
	    
	 //����� ������� ���������
	 void notification(Message message);
     
	 List<Review> getReviewByMechanic(Mechanic mechanic, Integer first, Integer max);
	 
	 Number getSizeReviewByMechanic(Mechanic mechanic);
	
     List<Review> getReviewBySto(Sto sto, Integer first, Integer max);
     
     Number getSizeReviewBySto(Sto sto);
}