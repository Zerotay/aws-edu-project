package com.aws_project.chatbot.board.repository;

import com.aws_project.chatbot.board.dto.BoardListResponseDto;
import com.aws_project.chatbot.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {
//    public List<Board> findAllBy;
}
