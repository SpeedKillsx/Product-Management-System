package com.managementproduct.backend.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE (:category_name IS NULL OR p.category.name = :category_name) " +
           "AND (:name IS NULL OR p.name =:name) " +
           "AND (:price IS NULL OR p.price = :price) " +
           "AND (:quantity IS NULL OR p.quantity = :quantity)"+
           "AND (:description IS NULL OR p.description = :description)")
    List<Product> multiSearch(@Param("category_name") String category_name,
                              @Param("name") String name, 
                              @Param("price") Double price, 
                              @Param("quantity") Integer quantity,
                              @Param("description") String description);
}
