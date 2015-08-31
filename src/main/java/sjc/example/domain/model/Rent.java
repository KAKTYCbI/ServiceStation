package sjc.example.domain.model;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Rent {
	
	private Long id;
	
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Date dateStart;
	
	@NotEmpty
	private Long price;
	
	private Sto sto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	
	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Sto getSto() {
		return sto;
	}

	public void setSto(Sto sto) {
		this.sto = sto;
	}
	
	

}
