package com.managementproduct.backend.Product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.managementproduct.backend.Category.Category;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "api/v1/produits")
public class ProductController {
    
    private final ProductService productService;
    
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/")
    public List<Product> getAllProduct() {
        return this.productService.getAllProducts();
    }
    @PostMapping("/")
    public Product addProduct(@RequestBody Product product) throws IllegalStateException{
        return this.productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product,    @PathVariable Long id){
        return this.productService.updateProduct(product, id);
    }
    
    @DeleteMapping("/{id}")
    public  HttpStatusCode   deleteProduct(@PathVariable Long id){
        return this.productService.deleteProduct(id);
    }

    @GetMapping("/search")
    public List<Product> multiSearch(@RequestParam(required = false) Category category, 
                                    @RequestParam(required = false) String description,
                                    @RequestParam(required = false) Double price, 
                                    @RequestParam(required = false) Integer quantity){
        return this.productService.geProductsByMulti(category, description, price, quantity);
    }

}
