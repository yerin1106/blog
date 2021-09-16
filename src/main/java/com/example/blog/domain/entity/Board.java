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

// Entity = 관련있는 속성들이 모여서 의미있는 하나의 정보 단위
// Auditing 기능 = Spring Data JPA에서 시간에 대해서 자동으로 값을 넣어주는 기능
@EntityListeners(AuditingEntityListener.class) //리스너를 통해 자동으로 값 삽입, JPA에게 해당 Entity는 Auditing 기능을 사용함을 알림

public class Board {
    @Id //기본 키 매핑
    @GeneratedValue //주키의 값을 위한 자동 생성 전략을 명시하는데 사용
    private Long id;

    @Column(length=10, nullable = false) //필드와 컬럼 매핑
    private String author;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column
    private Long fileId;

    @CreatedDate //Entity가 생성되어 저장될 때 시간이 자동 저장
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 Entity의 값을 변경할 때 시간이 자동 저장
    private LocalDateTime modifiedDate;

    //객체를 생성하기 위한 패턴(생성자, 수정자, 빌더 패턴 있음)
    @Builder //모델 객체를 생성할 때 Builder를 자동으로 추가
    public Board(Long id, String author, String title, String content, Long fileId){
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.fileId = fileId;
    }
}
