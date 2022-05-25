package fr.todd.ecommerce.service.dto;

import java.util.Objects;

public class ClientDTO {

    // TODO add checks on fields
    private String username;
    private String email;

    private String password;
    private String passwordConfirmation;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public boolean passwordsMatch() {
        return this.passwordConfirmation == this.password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTO that = (ClientDTO) o;
        return username.equals(that.username) && email.equals(that.email) && password.equals(that.password)
                && passwordConfirmation.equals(that.passwordConfirmation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, password, passwordConfirmation);
    }

    @Override
    public String toString() {
        return "ContactDTO{" +
                "name='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirmation='" + passwordConfirmation + '\'' +
                '}';
    }
}
