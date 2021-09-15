package com.example.blog.service;

import com.example.blog.domain.entity.Board;
import com.example.blog.domain.repository.BoardRepository;
import com.example.blog.dto.BoardDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    private BoardRepository boardRepository; //데이터 조작을 담당

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // 글쓰기 Form에서 내용을 입력한 뒤, '글쓰기' 버튼을 누르면 post 형식으로 요청이 오고,
    // BoardService의 savePost()를 실행
    @Transactional // 클래스에 트랜잭션 기능이 적용된 프록시 객체가 생성
    public Long savePost(BoardDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getId();
    }

    // 게시물의 목록 가져오기
    // Repository에서 모든 데이터를 조회하여, BoardDto List에 데이터를 넣어 반환
    @Transactional
    public List<BoardDto> getBoardList(){
        List<Board> boardList = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Board board: boardList){
            BoardDto boardDto = BoardDto.builder()
                    .id(board.getId())
                    .author(board.getAuthor())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .createdDate(board.getCreatedDate())
                    .build();
            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }

    //게시글을 클릭하면 게시물의 내용이 화면에 출력
    @Transactional
    public BoardDto getPost(Long id) {
        Board board = boardRepository.findById(id).get();

        BoardDto boardDto = BoardDto.builder()
                .id(board.getId())
                .author(board.getAuthor())
                .title(board.getTitle())
                .content(board.getContent())
                .createdDate(board.getCreatedDate())
                .build();
        return boardDto;
    }

}
