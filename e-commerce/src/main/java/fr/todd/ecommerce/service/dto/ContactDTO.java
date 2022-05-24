package fr.todd.ecommerce.service.dto;

import java.util.Objects;

public class ContactDTO {

    private String name;
    private String email;

    private String password;
    private String passwordConfirmation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDTO that = (ContactDTO) o;
        return name.equals(that.name) && email.equals(that.email) && password.equals(that.password)
                && passwordConfirmation.equals(that.passwordConfirmation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, password, passwordConfirmation);
    }

    @Override
    public String toString() {
        return "ContactDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirmation='" + passwordConfirmation + '\'' +
                '}';
    }
}
