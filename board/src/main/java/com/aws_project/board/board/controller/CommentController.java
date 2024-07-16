package com.aws_project.board.board.controller;

import com.aws_project.board.board.dto.*;
import com.aws_project.board.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board/{boardId}/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Long> create(@PathVariable Long boardId, @RequestBody CommentCreateRequestDto commentCreateRequestDto){
        return ResponseEntity.ok(commentService.create(boardId, commentCreateRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<CommentListResponseDto>>retrieveList(@PathVariable Long boardId){
        return ResponseEntity.ok(commentService.search(boardId));
    }


//    @DeleteMapping("/{boardId}")
//    public ResponseEntity<Void> delete(@PathVariable Long boardId){
//        return ResponseEntity.ok(boardService.delete(boardId));
//    }

    @PostMapping("/{commentId}")
    public ResponseEntity<?> delete(@PathVariable Long commentId, @RequestBody CommentDeleteRequestDto commentDeleteRequestDto){
        commentService.delete(commentId, commentDeleteRequestDto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{commentId}")
    public ResponseEntity<Long> update(@PathVariable Long commentId, @RequestBody CommentUpdateRequestDto commentUpdateRequestDto){
        return ResponseEntity.ok(commentService.update(commentId, commentUpdateRequestDto));
    }
}
