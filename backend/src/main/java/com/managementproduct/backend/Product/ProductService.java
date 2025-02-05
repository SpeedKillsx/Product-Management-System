package com.managementproduct.backend.Product;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.stereotype.Service;

import com.managementproduct.backend.Category.Category;
import com.managementproduct.backend.Category.CategoryRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final CategoryRepository prodCategoryRepository;
    public ProductService(ProductRepository productRepository, CategoryRepository prodCategoryRepository) {
        this.productRepository = productRepository;
        this.prodCategoryRepository = prodCategoryRepository;
    }

    

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public Product addProduct(Product product) throws EntityNotFoundException {
        Long categoryId = product.getCategory().getId();
        Category category = prodCategoryRepository.getCategoryByID(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category with ID " + categoryId + " does not exist"));

        product.setCategory(category);

        return this.productRepository.save(product);
    }

    public Product updateProduct(Product product, Long id) throws EntityNotFoundException{
        Product previousProduct = this.productRepository.findById(id).orElseThrow(()->
        new EntityNotFoundException("EROR: The selected product doesn't exist."));
        previousProduct.update(product);
         return this.productRepository.save(previousProduct);
    }

    public HttpStatusCode deleteProduct(Long id) throws EntityNotFoundException{
        if (this.productRepository.findById(id).isPresent()){
            this.productRepository.deleteById(id);
            return ResponseEntity.ok().body("The row is delted").getStatusCode();
        }
        return ResponseEntity.ok().body("The row is not delted").getStatusCode();
    }
}
