package sjc.example.domain.model;

import java.util.List;


public class Sto {
	
	private Long id;
	
	private String name;
	
	private Double rating;
	
	private List<Review> reviews;
	
	private List<Mechanic> mechanics;
	
	private List<Application> orders;

	/*public Sto(Long id, String name, Double rating, List<Mechanic> mechanics, List<Review> reviews, List<Application> orders  ){
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.mechanics = mechanics;
		this.reviews = reviews;
		this.orders = orders;
	}*/
	
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

	
}
