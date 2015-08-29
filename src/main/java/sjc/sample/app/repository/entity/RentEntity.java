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
import javax.persistence.Table;

import org.dozer.Mapping;



@Entity
@Table(name="rent")
public class RentEntity {
	
	@Id
	@Mapping("id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rent_id")
	private Long rentId;
	
	@Mapping("dateStart")
	@Column(name="Date")
	private Date start;
		
	@Mapping("price")
	@Column(name="price")
	private Float price;

	@Mapping("sto")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "sto_sto_id", nullable = false)
	private StoEntity sto;
	
	public Long getRentId() {
		return rentId;
	}

	public void setRentId(Long rentId) {
		this.rentId = rentId;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public StoEntity getSto() {
		return sto;
	}

	public void setSto(StoEntity sto) {
		this.sto = sto;
	}



	
}
