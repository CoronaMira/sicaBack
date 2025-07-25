package edu.practice.sica.service;

import edu.practice.sica.entity.Product;
import edu.practice.sica.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product create(Product product) {
        Long productId = productRepository.save(product);
        product.setId(productId);
        return product;
    }

    public Product update(Long id, Product updatedProduct) {
        return productRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedProduct.getName());
                    existing.setDescription(updatedProduct.getDescription());
                    existing.setPrice(updatedProduct.getPrice());
                    existing.setStock(updatedProduct.getStock());
                    existing.setCategory(updatedProduct.getCategory());
                    productRepository.update(id, existing);
                    return existing;
                })
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public void deleteById(Long id) {
        productRepository.delete(id);
    }

}
