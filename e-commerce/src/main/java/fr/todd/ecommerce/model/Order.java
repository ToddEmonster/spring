package fr.todd.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Entité représentant les commandes des clients
 */
@Entity(name="table_order")
public class Order {

    @Id
    private Long id;

    @Column(name="date_created")
    private LocalDate dateCreated;
    private String status;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
    // si la colonne de jointure s'appelle "id", pas besoin de mettre @JoinColumn
    // (name="table_id"), c'est fait automatiquement

    // Pourquoi cascade ?
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderProduct> orderProducts;

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

    public void setStatus(String status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @JsonIgnoreProperties({ "order" })
    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public Double getTotalOrderPrice() {
        return this.orderProducts
                .stream()
                .map(OrderProduct::getTotalPrice)
                .reduce(0.0, Double::sum);
    }

    public int getNumberOfProducts() {
        return this.orderProducts.size();
    }

    public int getTotalNumberOfProducts() {
        return this.orderProducts
                .stream()
                .map(OrderProduct::getQuantity)
                .reduce(0, Integer::sum);
    }

    public void addProduct(Product product, int quantity) {
        OrderProduct newOrderProduct = new OrderProduct(this, product, quantity);
        this.orderProducts.add(newOrderProduct);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateCreated=" + dateCreated +
                ", status='" + status + '\'' +
                ", client=" + client +
                ", orderProducts=" + orderProducts +
                '}';
    }
}
