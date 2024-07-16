package com.aws_project.board.board.service;

import com.aws_project.board.board.dto.*;
import com.aws_project.board.board.entity.Board;
import com.aws_project.board.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long create(BoardCreateRequestDto boardCreateRequestDto) {
        Board board = Board.builder()
                .nickname(boardCreateRequestDto.getNickname())
                .password(boardCreateRequestDto.getPassword())
                .title(boardCreateRequestDto.getTitle())
                .content(boardCreateRequestDto.getContent())
                .build();

        return boardRepository.save(board).getId();
    }

    @Transactional(readOnly = true)
    public Page<BoardListResponseDto> search(BoardListRequestDto boardListRequestDto, Pageable pageable) {
        return boardRepository.searchBoardCustom(boardListRequestDto, pageable);
    }

    @Transactional(readOnly = true)
    public BoardDetailResponseDto getDetail(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(RuntimeException::new);
        return BoardDetailResponseDto.toBoardDetailResponseDto(board);
    }

    public void delete(Long boardId, BoardDeleteRequestDto boardDeleteRequestDto) {
        // check passwd
        Board board = boardRepository.findById(boardId).orElseThrow(RuntimeException::new);
        if (!board.getPassword().equals(boardDeleteRequestDto.getPassword())) {
            throw new RuntimeException();

        }
        boardRepository.deleteById(boardId);
//        boardRepository.delete(board);
    }

    public Long update(Long boardId, BoardUpdateRequestDto boardUpdateRequestDto) {
        Board board = boardRepository.findById(boardId).orElseThrow(RuntimeException::new);
        if (!board.getPassword().equals(boardUpdateRequestDto.getPassword())) {
            throw new RuntimeException();
        }
        boardRepository.save(Board.update(board, boardUpdateRequestDto));
        return boardId;
    }
}
