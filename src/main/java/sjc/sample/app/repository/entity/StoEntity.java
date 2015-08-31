package sjc.sample.app.repository.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.dozer.Mapping;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;



@Entity
@Table(name="sto")
public class StoEntity {
	
	@Id
	@Mapping("id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sto_id")
	private Long stoId;
	
	@Mapping("name")
	@Column(name="name")
	private String name;
	
	@Mapping("rating")
	@Column(name="rating")
	private Float rating;
	
	@Mapping("reviews")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sto", orphanRemoval=true)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	private List<ReviewEntity> reviews;
	
	/*@Mapping("mechanics")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sto", orphanRemoval=true)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private List<MechanicEntity> mechanics;
	
	@Mapping("orders")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sto", orphanRemoval=true)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	private List<ApplicationEntity> orders;
	*/
	@Mapping("price")
	@Column(name="salary")
	private  Long price;
	
	public Long getStoId() {
		return stoId;
	}

	public void setStoId(Long stoId) {
		this.stoId = stoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public List<ReviewEntity> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewEntity> reviews) {
		this.reviews = reviews;
	}

	/*public List<MechanicEntity> getMechanics() {
		return mechanics;
	}

	public void setMechanics(List<MechanicEntity> mechanics) {
		this.mechanics = mechanics;
	}

	public List<ApplicationEntity> getOrders() {
		return orders;
	}

	public void setOrders(List<ApplicationEntity> orders) {
		this.orders = orders;
	}*/

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}


	

}
