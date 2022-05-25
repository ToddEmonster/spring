package fr.cda.ecommerce.service;

import java.util.List;

import fr.cda.ecommerce.exception.StockException;
import fr.cda.ecommerce.model.Product;

public interface ProductService {

	public List<Product> getAllProducts();

	public Product getProductById(Long id);

	public Product save(Product product);

	public boolean isProductAvailable(Product product, int quantity);

	public void removeProduct(Product product, int quantity) throws StockException;

}
