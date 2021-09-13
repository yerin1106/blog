package com.example.blog.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter //해당 객체의 값을 얻는 것, 단순히 필드를 리턴하는 것
@Entity //객체와 테이블 매핑
@NoArgsConstructor(access = AccessLevel.PROTECTED) //생성자(객체의 초기화를 담당하는 서브루틴)를 자동으로 생성해주는 애노테이션
@EntityListeners(AuditingEntityListener.class) //리스너를 통해 자동으로 값 삽입
public class Board {
    @Id //기본 키 매핑
    @GeneratedValue
    private Long id;

    @Column(length=10, nullable = false) //필드와 컬럼 매핑
    private String author;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Builder
    public Board(Long id, String author, String title, String content){
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
    }

}
