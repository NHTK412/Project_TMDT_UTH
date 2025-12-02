package com.example.clothingstore.mapper;

import org.springframework.stereotype.Component;

import com.example.clothingstore.dto.category.CategoryRequestDTO;
import com.example.clothingstore.dto.category.CategoryResponseDTO;
import com.example.clothingstore.dto.category.CategorySummaryDTO;
// import com.example.clothingstore.dto.category.CategorySummaryDTO;
import com.example.clothingstore.model.Category;

@Component
public class CategoryMapper {

    public CategorySummaryDTO convertCategoryToCategorySummaryDTO(Category category) {
        CategorySummaryDTO categorySummaryDTO = new CategorySummaryDTO();

        categorySummaryDTO.setCategoryId(category.getCategoryId());

        categorySummaryDTO.setCategoryName(category.getCategoryName());

        categorySummaryDTO.setProductCount(category.getProducts().size());

        return categorySummaryDTO;
    }

    public CategoryResponseDTO convertCategoryToCategoryResponseDTO(Category category) {
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();

        categoryResponseDTO.setCategoryId(category.getCategoryId());

        categoryResponseDTO.setCategoryName(category.getCategoryName());

        categoryResponseDTO.setDescription(category.getDescription());

        categoryResponseDTO.setStatus(category.getStatus());

        return categoryResponseDTO;
    }

    public Category convertCategoryRequestToModel(CategoryRequestDTO categoryRequestDTO, Category category) {

        category.setCategoryName(categoryRequestDTO.getCategoryName());

        category.setDescription(categoryRequestDTO.getDescription());

        category.setStatus(categoryRequestDTO.getStatus());

        return category;
    }

}
