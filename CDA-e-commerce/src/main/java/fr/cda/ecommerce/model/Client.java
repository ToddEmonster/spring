package fr.cda.ecommerce.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "table_client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "table_client_role", 
			joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
			)
	private Collection<Role> roles;

	public Client() {

	}

	public Client(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
}
