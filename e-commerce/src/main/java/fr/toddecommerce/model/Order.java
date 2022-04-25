package fr.toddecommerce.model;

import java.time.LocalDate;

/**
 * Entité représentant les commandes des clients
 */
public class Order {

    private Long id;
    private LocalDate dateCreated;
    private String status;
    private Long idClient;

    public Order() {
        super();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public Long getIdClient() {
        return idClient;
    }
}
