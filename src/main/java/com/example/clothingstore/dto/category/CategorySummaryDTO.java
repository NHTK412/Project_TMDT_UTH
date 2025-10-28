package com.example.clothingstore.dto.category;

import com.example.clothingstore.model.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategorySummaryDTO {

    private Integer categoryId;

    private String categoryName;

    private String description;

    private String status;

    public CategorySummaryDTO(Category category) {
        this.categoryId = category.getCategoryId();
        this.categoryName = category.getCategoryName();
        this.description = category.getDescription();
        this.status = category.getStatus();
    }
}
