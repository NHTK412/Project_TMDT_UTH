package com.example.clothingstore.dto.category;

import com.example.clothingstore.enums.CategoryStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDTO {

    private Integer categoryId;

    private String categoryName;

    private String description;

    private CategoryStatusEnum status;

}
