package com.pareekdevansh.blog_apis.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private Long id;

    @NotEmpty
    @Size(min = 3, message = "Name should have minimum 3 characters")
    private String name;

    @NotEmpty
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty
    @Size(min = 5, message = "Password should have minimum 5 characters")
    //@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "Password should contain atleast one uppercase, one lowercase and one digit")
    private String password;

    private String about;
}
