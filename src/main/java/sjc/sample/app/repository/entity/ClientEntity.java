package sjc.sample.app.repository.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.dozer.Mapping;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name = "client")
@DiscriminatorValue("client")
@PrimaryKeyJoinColumn(name = "users_user_id")
public class ClientEntity extends UserPrincipalEntity {
	
	@Id
	@Mapping("id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_id")
	private Long clientId; 
	
	@Mapping("messages")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client", orphanRemoval=true)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	private List<MessageEntity> messages;

	public List<MessageEntity> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageEntity> messages) {
		this.messages = messages;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	

	



	
	
	
}
