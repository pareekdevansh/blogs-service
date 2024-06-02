package com.pareekdevansh.blog_apis.repository;

import com.pareekdevansh.blog_apis.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
