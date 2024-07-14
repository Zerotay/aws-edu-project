package com.aws_project.chatbot.board.repository;

import com.aws_project.chatbot.board.dto.BoardListRequestDto;
import com.aws_project.chatbot.board.dto.BoardListResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BoardRepositoryCustomImpl implements BoardRepositoryCustom{

    @Override
    public Page<BoardListResponseDto> searchBoardCustom(BoardListRequestDto boardListRequestDto, Pageable pageable) {
        return null;
    }
}
