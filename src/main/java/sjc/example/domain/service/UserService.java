package sjc.example.domain.service;

import java.util.List;

import sjc.example.domain.model.Review;
import sjc.example.domain.model.UserPrincipal;

public interface UserService {
	
	 // Авторизация пользователя на сайте
	 UserPrincipal getUser(String login, String password);
	 
	 //возвращает пользователя по ИД
	 UserPrincipal getUserByID(Long userId);
	 
	 //возвращает пользователя по имени
	 UserPrincipal getUserByName(String name);
	 
	 // метод возвращает список всех клиентов
	 List<UserPrincipal> getUsers();
	 
	 // метод возвращает список всех отзывов
     List<Review> getReview();
		 
	 // сохранение введенной информации об аккаунте от клиента
	 void saveUser(UserPrincipal user);

	 // удаление выбранного клиента
	 void deleteUser(UserPrincipal user);

}
