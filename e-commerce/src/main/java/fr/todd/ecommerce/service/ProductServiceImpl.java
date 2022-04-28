package fr.todd.ecommerce.service;

import fr.todd.ecommerce.exception.ResourceNotFoundException;
import fr.todd.ecommerce.exception.StockException;
import fr.todd.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("products")
public class ProductServiceImpl implements ProductService {

    private final List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getAllProducts() {
        return this.products;
    }

    @Override
    public Product getProductById(Long id) throws ResourceNotFoundException {
        Optional<Product> optionalProduct = this.products
                .stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();

        if (!optionalProduct.isPresent()) {
            throw new ResourceNotFoundException();
        } else {
            return optionalProduct.get();
        }
    }

    @Override
    public Product save(Product product) {
        boolean productExists = this.products
                .stream()
                .anyMatch(existingProduct -> existingProduct.equals(product));
        if (!productExists) {
            this.products.add(product);
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
        if (!this.isProductAvailable(product, quantity)) {
            throw new StockException();
        } else {
            for (Product existingProduct : this.products) {
                existingProduct.setQuantity(existingProduct.getQuantity() - quantity);
            }
        }
    }
}
