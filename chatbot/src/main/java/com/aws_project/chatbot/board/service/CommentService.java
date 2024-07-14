package com.aws_project.chatbot.board.service;

import com.aws_project.chatbot.board.dto.*;
import com.aws_project.chatbot.board.entity.Board;
import com.aws_project.chatbot.board.entity.Comment;
import com.aws_project.chatbot.board.repository.BoardRepository;
import com.aws_project.chatbot.board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public Long create(Long boardId, CommentCreateRequestDto commentCreateRequestDto) {
        Board board = boardRepository.findById(boardId).orElseThrow(RuntimeException::new);
        Comment comment = Comment.builder()
                .board(board)
                .nickname(commentCreateRequestDto.getNickname())
                .password(commentCreateRequestDto.getPassword())
                .content(commentCreateRequestDto.getContent())
                .build();
        return commentRepository.save(comment).getId();
    }

    @Transactional(readOnly = true)
    public List<CommentListResponseDto> search(Long boardId) {
        return commentRepository.searchCustom(boardId);
//        return commentRepository.findAllByBoard_Id(boardId);
    }

    public void delete(Long commentId, CommentDeleteRequestDto commentDeleteRequestDto) {
        // check passwd
        Comment comment = commentRepository.findById(commentId).orElseThrow(RuntimeException::new);
        if (!comment.getPassword().equals(commentDeleteRequestDto.getPassword())) {
            throw new RuntimeException();
        }
        commentRepository.deleteById(commentId);
    }

    public Long update(Long commentId, CommentUpdateRequestDto commentUpdateRequestDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(RuntimeException::new);
        if (!comment.getPassword().equals(commentUpdateRequestDto.getPassword())) {
            throw new RuntimeException();
        }
        commentRepository.save(Comment.update(comment, commentUpdateRequestDto));
        return commentId;
    }

}
