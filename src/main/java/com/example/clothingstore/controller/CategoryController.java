package com.example.clothingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.clothingstore.dto.category.CategorySummaryDTO;
import com.example.clothingstore.repository.CategoryService;
import com.example.clothingstore.util.ApiResponse;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategorySummaryDTO>>> getAllCategory(@RequestParam Integer page,
            @RequestParam Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        
        List<CategorySummaryDTO> categorySummaryDTOs = categoryService.getAllCategory(pageable);

        return ResponseEntity.ok(new ApiResponse<List<CategorySummaryDTO>>(null, null, categorySummaryDTOs));
    }

}
