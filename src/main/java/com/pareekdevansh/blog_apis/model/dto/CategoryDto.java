package com.pareekdevansh.blog_apis.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {
    private Long id;

    @NotEmpty
    @Size(max = 31, message = "Category title characters must be less than 32")
    private String title;

    @Size(max = 1023, message = "Category description characters must be less than 1024")
    private String description;
}
