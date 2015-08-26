package sjc.example.domain.model;

import java.util.List;

public class Client extends UserPrincipal {
	
	private Long id;

	private List<Message> messages;
	

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
