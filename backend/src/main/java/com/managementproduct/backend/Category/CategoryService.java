package com.managementproduct.backend.Category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    
    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return this.categoryRepository.findAll();
    }


    public Category insertCategory(Category category){
        
        return this.categoryRepository.save(category);
    }

    public Category getCategoryById(Long id) throws IllegalStateException {
        
        return this.categoryRepository.findById(id).orElseThrow(()-> new IllegalStateException("ERROR : Categpry with ID : "+id+" doesn't exist"));
       
    }



    
    
}
