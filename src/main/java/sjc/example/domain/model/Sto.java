package sjc.example.domain.model;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


public class Sto {
	
	private Long id;
	
	@NotEmpty @Size(min=1, max=30)
	private String name;
	
	@NotEmpty @Min(0) @Max(5)
	private Double rating;
	
	private Long price;
	
	private List<Review> reviews;
	
	private List<Mechanic> mechanics;
	
	private List<Application> orders;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Mechanic> getMechanic() {
		return mechanics;
	}

	public void setMechanic(List<Mechanic> mechanics) {
		this.mechanics = mechanics;
	}

	public List<Application> getOrders() {
		return orders;
	}

	public void setOrders(List<Application> orders) {
		this.orders = orders;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public List<Mechanic> getMechanics() {
		return mechanics;
	}

	public void setMechanics(List<Mechanic> mechanics) {
		this.mechanics = mechanics;
	}

	
}
