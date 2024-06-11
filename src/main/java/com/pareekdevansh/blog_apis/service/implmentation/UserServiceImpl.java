package com.pareekdevansh.blog_apis.service.implmentation;

import com.pareekdevansh.blog_apis.exception.BadRequestException;
import com.pareekdevansh.blog_apis.exception.ResourceNotFoundException;
import com.pareekdevansh.blog_apis.mapper.UserMapper;
import com.pareekdevansh.blog_apis.model.entity.User;
import com.pareekdevansh.blog_apis.repository.UserRepository;
import com.pareekdevansh.blog_apis.service.UserService;
import com.pareekdevansh.blog_apis.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.userMapper.userDtoToUser(userDto);
        User newUser = this.userRepository.save(user);
        return this.userMapper.userToUserDto(newUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long userId) {
        if(userId == null || userId <= 0 || userDto == null) {
            throw new BadRequestException("Invalid user data provided");
        }
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User updatedUser = this.userRepository.save(user);
        return this.userMapper.userToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        if(userId == null || userId <= 0) {
            throw new BadRequestException("Invalid user id provided");
        }
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
        this.userRepository.delete(user);
    }

    @Override
    public UserDto getUserById(Long userId) {
        if(userId == null || userId <= 0) {
            throw new BadRequestException("Invalid user id provided");
        }
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
        return this.userMapper.userToUserDto(user);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        if(email == null || email.isEmpty()) {
            throw new BadRequestException("Invalid user email provided");
        }
        //User user = this.userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("user", "email", email));
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        return users.stream().map(user -> this.userMapper.userToUserDto(user)).toList();
    }
}
