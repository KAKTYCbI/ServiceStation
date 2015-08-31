package sjc.example.domain.model;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Review {

	private Long id;
	
	private Client client;
	
	private Mechanic mechanic;
	
	private Sto sto;
	
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Date date;
	
	@NotEmpty @Size(min=1, max=150)
	private String text;
	
	@NotEmpty @Min(1) @Max(5)
	private int rating;
	
	private Boolean visible;

	private String whom;
	
	private Long AppID;
	
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
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

	public String getWhom() {
		return whom;
	}

	public void setWhom(String whom) {
		this.whom = whom;
	}

	public Long getAppID() {
		return AppID;
	}

	public void setAppID(Long appID) {
		AppID = appID;
	}
	
	
}
