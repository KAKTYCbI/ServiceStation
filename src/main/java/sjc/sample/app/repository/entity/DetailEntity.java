package sjc.sample.app.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.dozer.Mapping;

@Entity
@Table(name="detail")
public class DetailEntity {
	
	@Id
	@Mapping("id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="detail_id")
	private Long detailId;
	
	@Mapping("name")
	@Column(name="name")
	private String name;
	
	@Mapping("price")
	@Column(name="price")
	private Long price;

	public Long getDetailId() {
		return detailId;
	}

	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	
	

}
