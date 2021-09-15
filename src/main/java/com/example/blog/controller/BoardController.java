package com.example.blog.controller;

import com.example.blog.dto.BoardDto;
import com.example.blog.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// controller는 사용자의 HTTP 요청이 진입하는 지점, 사용자에게 서버에서 처리된 데이터를 View와 함께 응답하게 해준다.
@Controller
public class BoardController {

    private BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    // getBoardList()를 통해 가져온 데이터를 Model을 통해 View에 전달
    @GetMapping("/")
    public String list(Model model){
        List<BoardDto> boardDtoList = boardService.getBoardList();
        model.addAttribute("postList", boardDtoList); //boardDtoList를 Board/list.html에 post로 전달
        return "board/list.html";
    }

    @GetMapping("/post")
    public String post(){
        return "board/post.html";
    }

    // post로 받은 데이터를 데이터베이스에 추가하는 것을 추가
    @PostMapping("/post")
    public String write(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "redirect:/"; //redirect 오른쪽의 주소로 URL 요청을 다시 하는 것
    }

    @GetMapping("/post/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        BoardDto boardDto = boardService.getPost(id);
        model.addAttribute("post", boardDto);
        return "board/detail.html";
    }
}
