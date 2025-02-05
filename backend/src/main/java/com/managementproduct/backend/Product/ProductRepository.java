package com.managementproduct.backend.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.managementproduct.backend.Category.Category;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE (:category IS NULL OR p.category = :category) " +
           "AND (:name IS NULL OR p.name LIKE %:name%) " +
           "AND (:price IS NULL OR p.price = :price) " +
           "AND (:quantity IS NULL OR p.quantity = :quantity)")
    List<Product> multiSearch(@Param("category") Category category,
                              @Param("name") String name, 
                              @Param("price") Double price, 
                              @Param("quantity") Integer quantity);
}
