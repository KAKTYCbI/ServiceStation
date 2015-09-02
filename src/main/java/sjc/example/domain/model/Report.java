package sjc.example.domain.model;

public class Report {
	
	private Long applicationPrice;
	
	private Float salaryPrice;
	
	private Long rentPrice;
	
	private Long detailPrice;
	
	private Long expenses;
	
	private Long profit;

	public Long getApplicationPrice() {
		return applicationPrice;
	}

	public void setApplicationPrice(Long applicationPrice) {
		this.applicationPrice = applicationPrice;
	}

	

	public Long getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Long rentPrice) {
		this.rentPrice = rentPrice;
	}

	public Long getDetailPrice() {
		return detailPrice;
	}

	public void setDetailPrice(Long detailPrice) {
		this.detailPrice = detailPrice;
	}

	public Long getExpenses() {
		return expenses;
	}

	public void setExpenses(Long expenses) {
		this.expenses = expenses;
	}


	public Long getProfit() {
		return profit;
	}

	public void setProfit(Long profit) {
		this.profit = profit;
	}

	public Float getSalaryPrice() {
		return salaryPrice;
	}

	public void setSalaryPrice(Float salaryPrice) {
		this.salaryPrice = salaryPrice;
	}
	
	

}
