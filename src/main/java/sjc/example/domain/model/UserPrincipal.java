package sjc.example.domain.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


public class UserPrincipal {

	private Long userId;

	@NotEmpty
	@Pattern(regexp = "[a-zA-Z0-9 ]*")
	@Size(min=1, max=32)
	private String name;

	private String login;
    
	
	@Size(min=8, max=32)
	private String password;
	
	@NotEmpty @Email
	private String email;
	
	@NotEmpty
	private String contact;

	private UserRole role;

	public UserPrincipal() {
	}

	public UserPrincipal(Long userId, String name) {
		super();
		this.userId = userId;
		this.name = name;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
    	
}
