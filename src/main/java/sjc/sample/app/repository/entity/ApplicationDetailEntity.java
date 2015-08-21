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
@Table(name="application_detail")
public class ApplicationDetailEntity {

	@Id
	@Mapping("id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="application_detail_id")
    private Long applicationDetailId;
	
	@Mapping("status")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "status_status_id", nullable = false)
	private StatusEntity status;
	
	@Mapping("name")
	@Column(name="name")
	private String name;
	
	@Mapping("dateOrder")
	@Column(name="date_order")
	private Date dateOrder;
	
	@Mapping("dateDelivery")
	@Column(name="date_delivery")
	private Date dateDelivery;
	
	@Mapping("application")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "application_application_id", nullable = false)
	private ApplicationEntity application;

	public Long getApplicationDetailId() {
		return applicationDetailId;
	}

	public void setApplicationDetailId(Long applicationDetailId) {
		this.applicationDetailId = applicationDetailId;
	}


	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public Date getDateDelivery() {
		return dateDelivery;
	}

	public void setDateDelivery(Date dateDelivery) {
		this.dateDelivery = dateDelivery;
	}

	public ApplicationEntity getApplication() {
		return application;
	}

	public void setApplication(ApplicationEntity application) {
		this.application = application;
	}

	
	
}
