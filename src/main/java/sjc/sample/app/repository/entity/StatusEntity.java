package sjc.sample.app.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.dozer.Mapping;

@Entity
@Table(name="status")
public class StatusEntity {

	@Id
	@Mapping("id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="status_id")
	private Long statusId;
	
	@Mapping("status")
	@Column(name="text")
	private String text;

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
