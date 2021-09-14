package com.example.blog.dto;

import com.example.blog.domain.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

// Controller와 Service 사이에서 데이터를 주고받는 DTO

@Getter // 값을 가져올 때
@Setter // 값을 저장
@ToString // 각각의 필드들을 (non static field) 출력
@NoArgsConstructor // 생성자를 자동으로 생성
public class BoardDto {
    private Long id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    // DTO에서 필요한 부분을 빌더 패턴을 통해 Entity로 만드는 일
    public Board toEntity(){
        Board build = Board.builder()
                .id(id)
                .author(author)
                .title(title)
                .content(content)
                .build();
        return build;
    }

    @Builder
    public BoardDto(Long id, String author, String title, String content, LocalDateTime createdDate, LocalDateTime modifiedDate){
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
