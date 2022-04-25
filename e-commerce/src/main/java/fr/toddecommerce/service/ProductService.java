package fr.toddecommerce.service;

import fr.toddecommerce.exception.ResourceNotFoundException;
import fr.toddecommerce.exception.StockException;
import fr.toddecommerce.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(Long id) throws ResourceNotFoundException;
    void save(Product product);
    boolean isProductAvailable(Product product, int quantity);
    void removeProduct(Product product, int quantity) throws StockException;
}
