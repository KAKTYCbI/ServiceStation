package sjc.sample.app.repository.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.dozer.Mapping;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="mechanic")
@PrimaryKeyJoinColumn(name = "user_id")
public class MechanicEntity extends UserPrincipalEntity{
	
	@Mapping("rating")
	@Column(name="rating")
	private Float rating;
	
	/*@Mapping("messages")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mechanic", orphanRemoval=true)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	private List<MessageEntity> messages;
	
	@Mapping("salarys")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mechanic", orphanRemoval=true)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	private List<SalaryEntity> salarys;
	*/
	@Mapping("reviews")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mechanic", orphanRemoval=true)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	private List<ReviewEntity> reviews;
	
	@Mapping("sto")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "sto_id", nullable = false)
	private StoEntity sto;
	
	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	/*public List<MessageEntity> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageEntity> messages) {
		this.messages = messages;
	}

	public List<SalaryEntity> getSalarys() {
		return salarys;
	}

	public void setSalarys(List<SalaryEntity> salarys) {
		this.salarys = salarys;
	}*/

	public List<ReviewEntity> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewEntity> reviews) {
		this.reviews = reviews;
	}

	public StoEntity getSto() {
		return sto;
	}

	public void setSto(StoEntity sto) {
		this.sto = sto;
	}



	
	
}
