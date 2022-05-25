package fr.cda.ecommerce.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import antlr.collections.List;
import fr.cda.ecommerce.model.Client;
import fr.cda.ecommerce.model.Role;

public class MyClientPrincipal implements UserDetails {

	private static final long serialVersionUID = 3642900504222895419L;
	private Client client;

	public MyClientPrincipal(Client client) {
		super();
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		ArrayList<SimpleGrantedAuthority> list = new ArrayList<>();
		
		for(Role role : client.getRoles()) {
			list.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return list;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return client.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return client.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
