package com.pareekdevansh.blog_apis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages =
		"com.pareekdevansh.blog_apis.repository")
@EntityScan("com.pareekdevansh.blog_apis.model.entity")
public class BloggingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloggingServiceApplication.class, args);
	}

}
