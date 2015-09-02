package sjc.example.domain.model;

import java.util.Date;

public class ReportInfo {
	
	private String Whom;
	
	private Sto sto;
	
	private Date dateStart;
	
	private Date dateFinish;

	public String getWhom() {
		return Whom;
	}

	public void setWhom(String whom) {
		Whom = whom;
	}

	public Sto getSto() {
		return sto;
	}

	public void setSto(Sto sto) {
		this.sto = sto;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateFinish() {
		return dateFinish;
	}

	public void setDateFinish(Date dateFinish) {
		this.dateFinish = dateFinish;
	}

	
}
