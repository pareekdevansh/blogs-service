package com.pareekdevansh.blog_apis.mapper;

import com.pareekdevansh.blog_apis.model.dto.UserDto;
import com.pareekdevansh.blog_apis.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "password", ignore = true)
    UserDto userToUserDto(User user);

    @Mapping(target = "id", ignore = true)
    User userDtoToUser(UserDto userDto);
}
