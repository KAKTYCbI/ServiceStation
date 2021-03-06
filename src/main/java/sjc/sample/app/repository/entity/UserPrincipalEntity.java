package sjc.sample.app.repository.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.dozer.Mapping;

import sjc.example.domain.model.UserRole;

@Entity()
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserPrincipalEntity {
	
	@Id
	@Mapping("userId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@Mapping("name")
	@Column(name = "name")
	private String name;

	@Mapping("login")
	@Column(name = "login")
	private String login;
	
	@Mapping("email")
	@Column(name="email")
	private String email;
	
	@Mapping("contact")
	@Column(name="contact")
	private String contact;

	@Mapping("password")
	@Column(name = "password")
	private String password;

	
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private UserRole role;

	public UserPrincipalEntity() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
	
}
