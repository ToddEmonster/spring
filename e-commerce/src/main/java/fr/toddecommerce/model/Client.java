package fr.toddecommerce.model;

/**
 * Entité représentant les clients
 */
public class Client {

    private Long id;

    private String username;
    private String password;

    public Client() {
        super();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}