package sjc.example.domain.model;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import javax.validation.constraints.Size;

public class Message {

	private Long id;
	
	private Client client;
	
	private Mechanic mechanic;
	
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Date date;
	
	@Size(min=15, max=150) 
	private String text;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
