package sjc.example.domain.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Salary {
	
	private Long id;
	
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Date date;
	
	@NotEmpty
	private Float summa;
	
	private Director director;
	
	private Mechanic mechanic;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getSumma() {
		return summa;
	}

	public void setSumma(Float summa) {
		this.summa = summa;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public Mechanic getMechanic() {
		return mechanic;
	}

	public void setMechanic(Mechanic mechanic) {
		this.mechanic = mechanic;
	}
	
	

}
