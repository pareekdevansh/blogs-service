package com.pareekdevansh.blog_apis.model.common;

import lombok.Data;

@Data
public class ApiResponse {
    private String message;
    private boolean success;

    public ApiResponse(String message, boolean b) {
        this.message = message;
        this.success = b;
    }
}
