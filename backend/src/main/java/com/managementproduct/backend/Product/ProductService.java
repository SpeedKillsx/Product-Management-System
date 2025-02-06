package com.managementproduct.backend.Product;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.stereotype.Service;

import com.managementproduct.backend.Category.Category;
import com.managementproduct.backend.Category.CategoryRepository;
import com.managementproduct.backend.DTO.ProductDTO;

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

    public Product addProduct(ProductDTO productDTO) throws EntityNotFoundException {
        Category category = prodCategoryRepository.findByName(productDTO.getCategory_name())
                .orElseThrow(() -> new EntityNotFoundException("Category with name " + productDTO.getCategory_name() + " does not exist"));
        
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setCategory(category);
        
        return this.productRepository.save(product);
    }

    public Product updateProduct(ProductDTO productDTO, Long id) throws EntityNotFoundException{
        Product previousProduct = this.productRepository.findById(id).orElseThrow(()->new EntityNotFoundException("EROR: The selected product doesn't exist."));
        Category category = prodCategoryRepository.findByName(productDTO.getCategory_name()).orElseThrow(() -> new EntityNotFoundException("Category with name " + productDTO.getCategory_name() + " does not exist"));
        
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setCategory(category);
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

    public List<Product> geProductsByMulti(String category_name, String name, Double price, Integer quantity, String description) {
        System.out.println("🔍 Received search parameters: ");
        System.out.println("name = " + name);
        System.out.println("category = " + category_name);
        System.out.println("price = " + price);
        System.out.println("quantity = " + quantity);
        System.out.println("description = " + description);
        return productRepository.multiSearch(category_name, name, price, quantity, description);
    }

    public ProductDTO converToDTO(Product p ){
        return new ProductDTO(p.getId(),p.getName(), p.getDescription(), p.getPrice(), p.getQuantity(), p.getCategory().getname());
    }


    
}
