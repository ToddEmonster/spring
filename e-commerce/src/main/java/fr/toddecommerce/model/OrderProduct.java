package fr.toddecommerce.model;

public class OrderProduct {

    private Long idOrder;
    private Long idProduct;
    private Integer quantity;

    public OrderProduct() {
        super();
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
