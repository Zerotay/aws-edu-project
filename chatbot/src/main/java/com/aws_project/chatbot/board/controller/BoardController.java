package com.aws_project.chatbot.board.controller;

import com.aws_project.chatbot.board.dto.BoardCreateRequestDto;
import com.aws_project.chatbot.board.dto.BoardListRequestDto;
import com.aws_project.chatbot.board.dto.BoardListResponseDto;
import com.aws_project.chatbot.board.entity.Board;
import com.aws_project.chatbot.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody BoardCreateRequestDto boardCreateRequestDto){
        Board board = boardService.create(boardCreateRequestDto);
        return ResponseEntity.ok(board.getId());
    }

    public ResponseEntity<Page<BoardListResponseDto>> retrieveList(BoardListRequestDto boardListRequestDto, @PageableDefault(size = 10)Pageable pageable){
        return ResponseEntity.ok(boardService.search(boardListRequestDto, pageable));
    }
}
