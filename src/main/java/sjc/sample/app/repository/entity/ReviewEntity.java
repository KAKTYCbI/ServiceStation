package sjc.sample.app.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Table;

import org.dozer.Mapping;



@Entity
@Table(name="review")
public class ReviewEntity {

	@Id
	@Mapping("id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="review_id")
	private Long reviewId;
	
	@Mapping("text")
	@Column(name="text")
	private String text;
	
	@Mapping("date")
	@Column(name="date")
	private Date date;
	
	@Mapping("rating")
	@Column(name="rating")
	private Float rating;
	
	@Mapping("visible")
	@Column(name="visible")
	private Boolean visible;
    
	@Mapping("client")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn( name = "client_client_id", nullable = false)
	private ClientEntity client;
	
	@Mapping("mechanic")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn( name = "mechanic_mechanic_id", nullable = false)
    private MechanicEntity mechanic;
	
	@Mapping("sto")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn( name = "sto_sto_id", nullable = false)
	private StoEntity sto;
	
	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}

	public MechanicEntity getMechanic() {
		return mechanic;
	}

	public void setMechanic(MechanicEntity mechanic) {
		this.mechanic = mechanic;
	}

	public StoEntity getSto() {
		return sto;
	}

	public void setSto(StoEntity sto) {
		this.sto = sto;
	}


	
	
	
	
}
