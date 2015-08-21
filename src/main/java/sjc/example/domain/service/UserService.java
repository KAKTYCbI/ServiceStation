package sjc.example.domain.service;

import java.util.List;

import sjc.example.domain.model.Review;
import sjc.example.domain.model.UserPrincipal;

public interface UserService {
	
	 // ����������� ������������ �� �����
	 UserPrincipal getUser(String login, String password);
	 
	 //���������� ������������ �� ��
	 UserPrincipal getUserByID(Long userId);
	 
	 //���������� ������������ �� �����
	 UserPrincipal getUserByName(String name);
	 
	 // ����� ���������� ������ ���� ��������
	 List<UserPrincipal> getUsers();
	 
	 // ����� ���������� ������ ���� �������
     List<Review> getReview();
		 
	 // ���������� ��������� ���������� �� �������� �� �������
	 void saveUser(UserPrincipal user);

	 // �������� ���������� �������
	 void deleteUser(UserPrincipal user);

}
