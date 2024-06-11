package com.pareekdevansh.blog_apis.service;

import com.pareekdevansh.blog_apis.model.common.ApiResponse;
import com.pareekdevansh.blog_apis.model.dto.CategoryDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId);

    void deleteCategory(Long categoryId);

    CategoryDto getCategoryById(Long categoryId);

    List<CategoryDto> getAllCategories();
}
