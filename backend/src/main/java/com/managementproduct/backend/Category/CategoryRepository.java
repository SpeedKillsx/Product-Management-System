package com.managementproduct.backend.Category;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

    @Query("SELECT c FROM Category  c WHERE c.id = ?1")
    Optional<Category> getCategoryByID(Long id);

    Optional<Category> findByName(String name);
}
