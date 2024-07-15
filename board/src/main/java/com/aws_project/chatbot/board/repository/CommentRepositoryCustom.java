package com.aws_project.chatbot.board.repository;

import com.aws_project.chatbot.board.dto.CommentListResponseDto;

import java.util.List;

public interface CommentRepositoryCustom {
    List<CommentListResponseDto> searchCustom(Long boardId);
}
