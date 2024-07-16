package com.aws_project.board.board.repository;

import com.aws_project.board.board.dto.BoardListRequestDto;
import com.aws_project.board.board.dto.BoardListResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardRepositoryCustom {
    Page<BoardListResponseDto> searchBoardCustom(BoardListRequestDto boardListRequestDto, Pageable pageable);
}
