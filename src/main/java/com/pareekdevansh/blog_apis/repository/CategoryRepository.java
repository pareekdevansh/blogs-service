package com.pareekdevansh.blog_apis.repository;

import com.pareekdevansh.blog_apis.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category , Long > {

}
