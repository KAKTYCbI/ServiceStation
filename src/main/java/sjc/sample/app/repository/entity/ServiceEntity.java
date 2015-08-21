package sjc.sample.app.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.dozer.Mapping;

@Entity
@Table(name="service")
public class ServiceEntity {
	
	@Id
	@Mapping("id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="service_id")
	private Long serviceId;
	
	@Mapping("name")
	@Column(name="name")
	private String name;
	
	@Mapping("price")
	@Column(name="price")
	private Float price;

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	

}
