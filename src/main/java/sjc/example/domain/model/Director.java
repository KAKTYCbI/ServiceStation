package sjc.example.domain.model;

import java.util.List;

public class Director extends UserPrincipal{
	
	private List<Salary> salary;


	public List<Salary> getSalary() {
		return salary;
	}

	public void setSalary(List<Salary> salary) {
		this.salary = salary;
	
	}


	
	
}
