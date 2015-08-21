package sjc.example.domain.service;

import java.util.List;

import sjc.example.domain.model.Application;
import sjc.example.domain.model.Client;
import sjc.example.domain.model.Message;
import sjc.example.domain.model.Review;
import sjc.example.domain.model.Sto;

public interface ClientService {

 // ����� ������� ����� � ��������� �������� � ������� ��� � ��������
	//c ������������ ���������� ������(������ ���)
 void addOrUpdateApplication(Application application);

 //����� ��������� ����������� ������������ �������
 List<Message> getMessageByClient(Client client);
 
 //����� ��������� �����
 void addReview(Review review);
 
 // ���������� ������ ������� ������ �� ��������� �������������
 // ��������������� �������
 List<Application> getApplication(Client client);
 
 //����� ��������� ������ ���
 List<Sto> getAllSto();
 
}