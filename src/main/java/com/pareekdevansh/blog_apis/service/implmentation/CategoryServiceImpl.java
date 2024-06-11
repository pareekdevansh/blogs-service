package com.pareekdevansh.blog_apis.service.implmentation;

import com.pareekdevansh.blog_apis.exception.ResourceNotFoundException;
import com.pareekdevansh.blog_apis.mapper.CategoryMapper;
import com.pareekdevansh.blog_apis.model.dto.CategoryDto;
import com.pareekdevansh.blog_apis.model.entity.Category;
import com.pareekdevansh.blog_apis.repository.CategoryRepository;
import com.pareekdevansh.blog_apis.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.categoryMapper.categoryDtoToCategory(categoryDto);
        Category newCategory = this.categoryRepository.save(category);
        return this.categoryMapper.categoryToCategoryDto(newCategory);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category" , "id", categoryId));
        category.setTitle(categoryDto.getTitle());
        category.setDescription(categoryDto.getDescription());
        Category updatedCategory = this.categoryRepository.save(category);
        return this.categoryMapper.categoryToCategoryDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category" , "id", categoryId));
        this.categoryRepository.deleteById(categoryId);
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category" , "id", categoryId));
        return this.categoryMapper.categoryToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = this.categoryRepository.findAll();
        return categories.stream().map(category -> this.categoryMapper.categoryToCategoryDto(category)).toList();
    }
}
