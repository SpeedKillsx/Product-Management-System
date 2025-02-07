package com.managementproduct.backend.Category;

import java.util.List;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/categories")
@Tag(name = "Categories", description = "API for category managment")
public class CategoryController {
    @Autowired
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    @Operation(
            summary = "List all available categories.",
            description = "This request is responsible of listing all the available categories on the database.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Liste des catégories récupérée avec succès",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Page.class))),
                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur",
                            content = @Content(mediaType = "application/json"))
            }
    )

    public List<Category> getAllCategories(){
        return this.categoryService.getAllCategories();
    }

    @PostMapping("/")
    @Operation(
            summary = "Add a category to the database.",
            description = "This request add a new category.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Category added",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Page.class))),
                    @ApiResponse(responseCode = "500", description = "ERROR during the adding of the category",
                            content = @Content(mediaType = "application/json"))
            }
    )
    public Category addCategory(@RequestBody Category category){
        return this.categoryService.insertCategory(category);
    }
}
