package sjc.example.domain.service;

import java.util.List;

import sjc.example.domain.model.Application;
import sjc.example.domain.model.Client;
import sjc.example.domain.model.Detail;
import sjc.example.domain.model.Message;
import sjc.example.domain.model.Review;
import sjc.example.domain.model.Service;
import sjc.example.domain.model.Status;
import sjc.example.domain.model.Sto;

public interface ClientService {

 // метод создает заказ с описанием проблемы и выбором СТО и механика
 //c возмощностью обнавления заявки(выбора СТО)
 void addOrUpdateApplication(Application application);


 //метод возращает уведомления определеного клиента
 List<Message> getMessageByClient(Client client);
 
 List<Message> getMessageByClientToPage(Client client, Integer first, Integer max);
 
 Number getSizeMessageBYClient(Client client);
 //метод дабавляет отзыв
 void addReview(Review review);
 
 // возвращает список заказов вмести со статусами определенного
 // авторизованного клиента
 List<Application> getApplication(Client client, Integer first, Integer max);
 
 Number getSizeApplicationByClient(Client client);
 
 List<Service> getService();
 
 List<Detail> getDetail();
 
 //метод возращает список СТО
 List<Sto> getAllSto(Integer first, Integer max);
 
 Number getSizeAllSto();
 
 Client getCilentById(Long id);
 
 void saveClient(Client client);
 
 Service getServiceByName(String name);
 
 Detail getDetailByName(String name);
 
 Status getStatusByName(String name);
}