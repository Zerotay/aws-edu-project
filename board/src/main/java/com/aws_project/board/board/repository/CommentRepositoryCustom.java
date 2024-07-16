package com.aws_project.board.board.repository;

import com.aws_project.board.board.dto.CommentListResponseDto;

import java.util.List;

public interface CommentRepositoryCustom {
    List<CommentListResponseDto> searchCustom(Long boardId);
}
