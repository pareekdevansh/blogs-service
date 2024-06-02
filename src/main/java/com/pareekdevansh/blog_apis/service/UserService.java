package com.pareekdevansh.blog_apis.service;

import com.pareekdevansh.blog_apis.model.dto.UserDto;

import java.util.List;


 public interface UserService {

    UserDto createUser(UserDto userDto);


     UserDto updateUser(UserDto userDto, Long userId);

     void deleteUser(Long userId);

     UserDto getUserById(Long userId);

     UserDto getUserByEmail(String email);

     List<UserDto> getAllUsers();

}
