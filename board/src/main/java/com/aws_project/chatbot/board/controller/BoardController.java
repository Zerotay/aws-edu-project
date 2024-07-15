package com.aws_project.chatbot.board.controller;

import com.aws_project.chatbot.board.dto.*;
import com.aws_project.chatbot.board.entity.Board;
import com.aws_project.chatbot.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody BoardCreateRequestDto boardCreateRequestDto){
        return ResponseEntity.ok(boardService.create(boardCreateRequestDto));
    }

    @GetMapping
    public ResponseEntity<Page<BoardListResponseDto>> retrieveList(BoardListRequestDto boardListRequestDto, @PageableDefault(size = 10)Pageable pageable){
        return ResponseEntity.ok(boardService.search(boardListRequestDto, pageable));
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<BoardDetailResponseDto> retrieveDetail(@PathVariable Long boardId){
        return ResponseEntity.ok(boardService.getDetail(boardId));
    }

//    @DeleteMapping("/{boardId}")
//    public ResponseEntity<Void> delete(@PathVariable Long boardId){
//        return ResponseEntity.ok(boardService.delete(boardId));
//    }

    @PostMapping("/{boardId}")
    public ResponseEntity<?> delete(@PathVariable Long boardId, @RequestBody BoardDeleteRequestDto boardDeleteRequestDto){
        boardService.delete(boardId, boardDeleteRequestDto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{boardId}")
    public ResponseEntity<Long> update(@PathVariable Long boardId, @RequestBody BoardUpdateRequestDto boardUpdateRequestDto){
        return ResponseEntity.ok(boardService.update(boardId, boardUpdateRequestDto));
    }
}
