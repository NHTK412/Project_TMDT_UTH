package com.example.clothingstore.dto.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategorySummaryDTO {

    private Integer categoryId;

    private String categoryName;

    private Integer productCount;

}
