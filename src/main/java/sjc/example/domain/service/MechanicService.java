package sjc.example.domain.service;
import java.util.List;

import sjc.example.domain.model.Application;
import sjc.example.domain.model.ApplicationDetail;
import sjc.example.domain.model.Mechanic;
import sjc.example.domain.model.Message;
import sjc.example.domain.model.Review;
import sjc.example.domain.model.Sto;

public interface MechanicService {

	 // метод возвращает список заявок заданного механика
	 List<Application> getCurrentApplication(Mechanic mechanic);
	 
	 //метод возращает список заявок на детали у определенного механика
	 List<ApplicationDetail> getAllApplicationDetail(Mechanic mechanic);
	 
	 //метод обнавляет заявку
	 void updateApplication(Application application);
	 
	 //возращает заявку по Id
	 Application getApplicationById(Long Id);
	    
	 //метод создает заявку на запчасть(запчасти)
	 void orderDetail(ApplicationDetail applicationDetail);
	    
	 //метод создает сообщение
	 void notification(Message message);
     
	 List<Review> getReviewByMechanic(Mechanic mechanic);
	
     List<Review> getReviewBySto(Sto sto);
}