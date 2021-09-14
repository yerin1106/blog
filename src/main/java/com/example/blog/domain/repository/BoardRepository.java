package com.example.blog.domain.repository;

import com.example.blog.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository는 데이터 조작을 담당하며, JpaRepository를 상속받는다
// JpaRepository의 값은 매핑할 Entity와 Id의 타입

public interface BoardRepository extends JpaRepository<Board, Long> {
}
