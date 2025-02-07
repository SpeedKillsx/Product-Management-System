package com.managementproduct.backend.Product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.managementproduct.backend.APIResponse.APIResponse;
import com.managementproduct.backend.Category.Category;
import com.managementproduct.backend.DTO.ProductDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

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
@Tag(name = "Products", description = "API for products managment")
@RequestMapping(path = "api/v1/produits")
public class ProductController {
    
    private final ProductService productService;
    
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/")
    @Operation(
        summary = "List all the available products.",
        description = "It lists all the products stored on DBMange database using a POST RESQUEST to the server",
        responses = {
            @ApiResponse(responseCode = "200", description = "The products where loaded succefully." , useReturnTypeSchema = true),
            @ApiResponse(responseCode = "500", description = "The products where not loaded succefully." , useReturnTypeSchema = true), 
        }    
    )
    
    public ResponseEntity<APIResponse<List<ProductDTO>>> getAllProduct() {
        List<Product> products = this.productService.getAllProducts();
        if (products.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        List<ProductDTO> productDTOs = products.stream()
                                           .map((product -> this.productService.converToDTO(product))) // Conversion en ProductDTO
                                           .collect(Collectors.toList());
        return ResponseEntity.ok(new APIResponse<>(productDTOs));

    }

    @PostMapping("/")
    @Operation(
        summary = "Add a new product",
        description = "This method is responsible for the products adding operation",
        parameters = {
            @Parameter(
               name = "name",
               required = true,
               description = "The name of the product"
            ),
            @Parameter(
                name = "description",
                required = true,
                description = "The description of the product"
            ),
            @Parameter(
                name = "price",
                required = true,
                description = "The price of the product"
            ),
            @Parameter(
                name = "quantity",
                required = true,
                description = "The quantity of the product"
            ),
            @Parameter(
                name = "category_name",
                required = true,
                description = "The category name of the product"
            )
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "The product is succefully added"),
            @ApiResponse(responseCode = "500", description = "The product is not added")
        }
    )
    public Product addProduct(@RequestBody ProductDTO product) throws IllegalStateException{
        return this.productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody ProductDTO product,    @PathVariable Long id){
        return this.productService.updateProduct(product, id);
    }
    
    @DeleteMapping("/{id}")
    public  HttpStatusCode   deleteProduct(@PathVariable Long id){
        return this.productService.deleteProduct(id);
    }

    @GetMapping("/search")
    public ResponseEntity<APIResponse<List<ProductDTO>>> multiSearch(@RequestParam(required = false) String category_name, 
                                    @RequestParam(required = false) String name,
                                    @RequestParam(required = false) Double price, 
                                    @RequestParam(required = false) Integer quantity,
                                    @RequestParam(required = false) String description){
        return ResponseEntity.ok(new APIResponse<>(this.productService.geProductsByMulti(category_name, name, price, quantity, description).stream().
        map((p->this.productService.converToDTO(p))).collect(Collectors.toList())
        ));
    }

}
