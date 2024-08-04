package com.pareekdevansh.blog_apis.model.entity;

import com.pareekdevansh.blog_apis.model.entity.BaseEntity;
import com.pareekdevansh.blog_apis.model.entity.Category;
import com.pareekdevansh.blog_apis.model.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseEntity {

    @Column(name = "title",length = 127,nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    private String createdAt;

    @Column(name = "updated_at", nullable = false)
    private String updatedAt;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "is_published", nullable = false)
    private Boolean isPublished;

    @ManyToOne
    private Category category;


    @ManyToOne
    private User user;
}


