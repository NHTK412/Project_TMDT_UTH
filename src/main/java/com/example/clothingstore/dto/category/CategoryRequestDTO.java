package com.example.clothingstore.dto.category;

import com.example.clothingstore.enums.CategoryStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryRequestDTO {

    private String categoryName;

    private String description;

    private CategoryStatusEnum status;
}
