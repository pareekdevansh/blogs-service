package com.pareekdevansh.blog_apis.mapper;

import com.pareekdevansh.blog_apis.model.dto.CategoryDto;
import com.pareekdevansh.blog_apis.model.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto categoryToCategoryDto(Category category);

    @Mapping(target = "id", ignore = true)
    Category categoryDtoToCategory(CategoryDto categoryDto);


}
