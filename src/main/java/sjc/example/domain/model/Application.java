package sjc.example.domain.model;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Application {
	
	private Long id;
	
	@NotEmpty
	private Long price;
	
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Date dateOrder;
	
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Date dateCompletion;
	
	private Status status;
	
	private List<Service> services;
	
	private List<Detail> details;
	
	private Client client;
	
	private Mechanic mechanic;
	
	private Sto sto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public Date getDateCompletion() {
		return dateCompletion;
	}

	public void setDateCompletion(Date dateCompletion) {
		this.dateCompletion = dateCompletion;
	}

	


	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public List<Detail> getDetails() {
		return details;
	}

	public void setDetails(List<Detail> details) {
		this.details = details;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Mechanic getMechanic() {
		return mechanic;
	}

	public void setMechanic(Mechanic mechanic) {
		this.mechanic = mechanic;
	}

	public Sto getSto() {
		return sto;
	}

	public void setSto(Sto sto) {
		this.sto = sto;
	}
	
	
	
	

}
