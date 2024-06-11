package com.pareekdevansh.blog_apis.controller;

import com.pareekdevansh.blog_apis.model.common.ApiResponse;
import com.pareekdevansh.blog_apis.model.dto.UserDto;
import com.pareekdevansh.blog_apis.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserContoller {

    private final UserService userService;

    @Autowired
    public UserContoller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        UserDto user = this.userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createdUser = this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Long id) {
        UserDto updatedUser = this.userService.updateUser(userDto, id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
        ApiResponse deleteResponse = new ApiResponse("User deleted successfully", true);
        return new ResponseEntity<>(deleteResponse, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = this.userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
