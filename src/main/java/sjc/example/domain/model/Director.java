package sjc.example.domain.model;

import java.util.List;

public class Director extends UserPrincipal{
	
	private Long salarys;
	
	private List<Salary> salary;


	public List<Salary> getSalary() {
		return salary;
	}

	public void setSalary(List<Salary> salary) {
		this.salary = salary;
	
	}

	public Long getSalarys() {
		return salarys;
	}

	public void setSalarys(Long salarys) {
		this.salarys = salarys;
	}
	
	


	
	
}
