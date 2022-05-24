package fr.todd.ecommerce.security;

import fr.todd.ecommerce.model.Client;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class MyClientPrincipal implements UserDetails {

    private final String username;
    private final String password;

    public MyClientPrincipal(Client client) {
        this.username = client.getUsername();
        this.password = client.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "MyClientPrincipal{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
