package com.pareekdevansh.blog_apis.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String propertyName;
    private Long propertyValue;
    public ResourceNotFoundException(String _resourceName , String _propertyName , Long _propertyValue ) {
        super("No " + _resourceName + " found with " + _propertyName + " : " + _propertyValue);
        resourceName = _resourceName;
        propertyName = _propertyName;
        propertyValue = _propertyValue;
    }

}
