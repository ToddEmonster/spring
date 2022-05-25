package fr.cda.ecommerce.dto;

import com.sun.istack.NotNull;

import fr.cda.ecommerce.validate.ValidePassword;
import fr.cda.ecommerce.validate.ValideUsername;

@ValidePassword
public class UserDto {
	
	@ValideUsername
	@NotNull
	private String username;

	@NotNull
	private String password;
	private String matchingPassword;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}
	


}