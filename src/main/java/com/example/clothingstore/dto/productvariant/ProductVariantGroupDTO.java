package com.example.clothingstore.dto.productvariant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariantGroupDTO {

    private String productName;

    private List<ProductVariantDTO> variants;
}
