package com.example.clothingstore.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.clothingstore.dto.category.CategorySummaryDTO;
import com.example.clothingstore.model.Category;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategorySummaryDTO> getAllCategory(Pageable pageable) {
        Page<Category> categories = categoryRepository.findAll(pageable);
        return categories.stream()
                .map((category) -> new CategorySummaryDTO(category))
                .toList();
    }

}
