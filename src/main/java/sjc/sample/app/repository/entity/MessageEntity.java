package sjc.sample.app.repository.entity;

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
@Table(name="message")
public class MessageEntity {

	@Id
	@Mapping("id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="message_id")
	private Long messageId;
	
	@Mapping("text")
	@Column(name="text")
	private String text;
	
	@Mapping("client")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_client_id", nullable = false )
    private ClientEntity client;
	
	@Mapping("mechanic")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mechanic_id", nullable = false)
	private MechanicEntity mechanic;

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}

	public MechanicEntity getMechanic() {
		return mechanic;
	}

	public void setMechanic(MechanicEntity mechanic) {
		this.mechanic = mechanic;
	}



	

	
	
}
