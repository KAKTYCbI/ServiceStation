package sjc.example.domain.model;

import java.util.List;

public class Client extends UserPrincipal {
	
	

	private List<Message> messages;
	

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	
	
	
}
