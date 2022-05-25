package fr.cda.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cda.ecommerce.exception.ResourceNotFoundException;
import fr.cda.ecommerce.exception.StockException;
import fr.cda.ecommerce.model.Product;
import fr.cda.ecommerce.repository.ProductRepository;

@Service("products")
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public Product getProductById(Long id) {
		
		Optional<Product> optional = productRepository.findById(id);
		
		Product result = productRepository.getReferenceById(id);
		
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new ResourceNotFoundException("oups");
		}
		
		
	}

	public Product save(Product product) {		
		return productRepository.save(product);
	}

	@Override
	public boolean isProductAvailable(Product product, int quantity) {
		return product.getQuantity() >= quantity;
	}

	@Override
	public void removeProduct(Product product, int quantity) throws StockException {

		if (isProductAvailable(product, quantity)) {
			product.setQuantity(product.getQuantity() - quantity);
			productRepository.save(product);
		} else {
			throw new StockException();
		}
	}
}
