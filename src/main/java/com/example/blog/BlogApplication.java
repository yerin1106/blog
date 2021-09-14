package com.example.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// Auditing 기능 = Spring Data JPA에서 시간에 대해서 자동으로 값을 넣어주는 기능
// JPA Aditing 기능을 사용하기 위해 main 클래스에 @EnableJpaAuditing
@EnableJpaAuditing
@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

}
