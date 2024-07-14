package com.aws_project.chatbot.board.service;

import com.aws_project.chatbot.board.dto.BoardCreateRequestDto;
import com.aws_project.chatbot.board.dto.BoardListRequestDto;
import com.aws_project.chatbot.board.dto.BoardListResponseDto;
import com.aws_project.chatbot.board.entity.Board;
import com.aws_project.chatbot.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Board create(BoardCreateRequestDto boardCreateRequestDto) {
        Board board = Board.builder()
                .nickname(boardCreateRequestDto.getNickname())
                .password(boardCreateRequestDto.getPassword())
                .title(boardCreateRequestDto.getTitle())
                .content(boardCreateRequestDto.getContent())
                .build();

        return boardRepository.save(board);
    }

//    public Page<BoardListResponseDto> search(BoardListRequestDto boardListRequestDto, Pageable pageable) {
//    }
}
