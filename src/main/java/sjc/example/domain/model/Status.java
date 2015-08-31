package sjc.example.domain.model;

import javax.validation.constraints.Size;

public class Status {
	
	private Long id;
	
	@Size(min=15, max=150)
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
