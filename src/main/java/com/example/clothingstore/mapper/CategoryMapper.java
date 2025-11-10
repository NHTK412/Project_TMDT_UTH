package com.example.clothingstore.mapper;

import com.example.clothingstore.dto.category.CategoryRequestDTO;
import com.example.clothingstore.dto.category.CategoryResponseDTO;
import com.example.clothingstore.dto.category.CategorySummaryDTO;
// import com.example.clothingstore.dto.category.CategorySummaryDTO;
import com.example.clothingstore.model.Category;

public class CategoryMapper {

    public static CategorySummaryDTO convertCategoryToCategorySummaryDTO(Category category) {
        CategorySummaryDTO categorySummaryDTO = new CategorySummaryDTO();

        categorySummaryDTO.setCategoryId(category.getCategoryId());

        categorySummaryDTO.setCategoryName(category.getCategoryName());

        return categorySummaryDTO;
    }

    public static CategoryResponseDTO convertCategoryToCategoryResponseDTO(Category category) {
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();

        categoryResponseDTO.setCategoryId(category.getCategoryId());

        categoryResponseDTO.setCategoryName(category.getCategoryName());

        categoryResponseDTO.setDescription(category.getDescription());

        categoryResponseDTO.setStatus(category.getStatus());

        return categoryResponseDTO;
    }

    public static Category convertCategoryRequestToModel(CategoryRequestDTO categoryRequestDTO, Category category) {

        category.setCategoryName(categoryRequestDTO.getCategoryName());

        category.setDescription(categoryRequestDTO.getDescription());

        category.setStatus(categoryRequestDTO.getStatus());

        return category;
    }

}
