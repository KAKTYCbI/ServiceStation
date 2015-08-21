package sjc.example.domain.service;

import java.util.Date;
import java.util.List;

import sjc.example.domain.model.Application;
import sjc.example.domain.model.Director;
import sjc.example.domain.model.Mechanic;
import sjc.example.domain.model.Rent;
import sjc.example.domain.model.Salary;
import sjc.example.domain.model.Sto;

// для работы с отчетностью
public interface ReportService {

 
 // метод возвращает зп за указаный переуд
 List<Salary> getListSalary(Date dateStart, Date dateFinish);

 // метод возвращает зп заданного директора за переуд
 List<Salary> getListDirectorSalary(Director director, Date dateStart, Date dateFinish);

  //метод возвращает зп за указаный переуд
  List<Salary> getListMechanicSalary(Mechanic mechanic, Date dateStart, Date dateFinish);


 // метод возвращает аренду заданного СТО за переуд
 List<Rent> getListSTORent(Sto sto, Date dateStart, Date dateFinish);

 // метод возвращает список выполненых заявок заданного СТО
 List<Application> getListStoApplicationToDate(Sto sto, Date dateStart, Date dateFinish);

 // метод возвращает список выполненых заявок заданного механика
 List<Application> getListMechanicApplicationToDate(Mechanic mechanic,Date dateStart, Date dateFinish);
 
 
    
}
