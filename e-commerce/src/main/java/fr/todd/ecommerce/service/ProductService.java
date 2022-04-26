package fr.todd.ecommerce.service;

import fr.todd.ecommerce.exception.ResourceNotFoundException;
import fr.todd.ecommerce.exception.StockException;
import fr.todd.ecommerce.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(Long id) throws ResourceNotFoundException;
    Product save(Product product);
    boolean isProductAvailable(Product product, int quantity);
    void removeProduct(Product product, int quantity) throws StockException;
}
