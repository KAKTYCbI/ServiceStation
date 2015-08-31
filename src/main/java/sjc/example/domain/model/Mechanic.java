package sjc.example.domain.model;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Mechanic extends UserPrincipal{
	
	private Long salary;
	
	private List<Salary> salarys;
	
	private List<Message> messages;
	
	@NotNull @Min(1) @Max(5)
	private Float rating;
	
	private List<Review> reviews;
	
	private Sto sto;

	
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Sto getSto() {
		return sto;
	}

	public void setSto(Sto sto) {
		this.sto = sto;
	}

	public List<Salary> getSalarys() {
		return salarys;
	}

	public void setSalarys(List<Salary> salarys) {
		this.salarys = salarys;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
	
	
	

}
