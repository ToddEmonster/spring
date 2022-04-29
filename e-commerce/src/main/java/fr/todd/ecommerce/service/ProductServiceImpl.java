package fr.todd.ecommerce.service;

import fr.todd.ecommerce.exception.ResourceNotFoundException;
import fr.todd.ecommerce.exception.StockException;
import fr.todd.ecommerce.model.Product;
import fr.todd.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("products")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) throws ResourceNotFoundException {
        Optional<Product> optionalProduct = this.productRepository.findById(id);

        if (!optionalProduct.isPresent()) {
            throw new ResourceNotFoundException();
        } else {
            return optionalProduct.get();
        }
    }

    @Override
    public Product save(Product product) {
        boolean productExists = this.productRepository.existsById(product.getId());
        if (!productExists) {
            this.productRepository.save(product);
            return product;
        }
        return null;
    }

    @Override
    public boolean isProductAvailable(Product product, int quantity) {
        try {
            Product foundProduct = this.getProductById(product.getId());

            return foundProduct.getQuantity() >= quantity;
        } catch (ResourceNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public void removeProduct(Product product, int quantity) throws StockException {
        if (this.isProductAvailable(product, quantity)) {
            product.setQuantity(product.getQuantity() - quantity);
            this.productRepository.save(product);
        } else {
            throw new StockException();
        }
    }
}
