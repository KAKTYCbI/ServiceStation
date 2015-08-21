package sjc.example.domain.service;

import java.util.Date;
import java.util.List;

import sjc.example.domain.model.Application;
import sjc.example.domain.model.Director;
import sjc.example.domain.model.Mechanic;
import sjc.example.domain.model.Rent;
import sjc.example.domain.model.Salary;
import sjc.example.domain.model.Sto;

// ��� ������ � �����������
public interface ReportService {

 
 // ����� ���������� �� �� �������� ������
 List<Salary> getListSalary(Date dateStart, Date dateFinish);

 // ����� ���������� �� ��������� ��������� �� ������
 List<Salary> getListDirectorSalary(Director director, Date dateStart, Date dateFinish);

  //����� ���������� �� �� �������� ������
  List<Salary> getListMechanicSalary(Mechanic mechanic, Date dateStart, Date dateFinish);


 // ����� ���������� ������ ��������� ��� �� ������
 List<Rent> getListSTORent(Sto sto, Date dateStart, Date dateFinish);

 // ����� ���������� ������ ���������� ������ ��������� ���
 List<Application> getListStoApplicationToDate(Sto sto, Date dateStart, Date dateFinish);

 // ����� ���������� ������ ���������� ������ ��������� ��������
 List<Application> getListMechanicApplicationToDate(Mechanic mechanic,Date dateStart, Date dateFinish);
 
 
    
}
