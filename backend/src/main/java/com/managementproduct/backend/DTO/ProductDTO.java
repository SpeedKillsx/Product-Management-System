package com.managementproduct.backend.DTO;

public class ProductDTO {
    private Long id;
    

    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private String category_name;

    public ProductDTO(Long id, String name, String description, Double price, Integer quantity,
            String category_name) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category_name = category_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    

}
