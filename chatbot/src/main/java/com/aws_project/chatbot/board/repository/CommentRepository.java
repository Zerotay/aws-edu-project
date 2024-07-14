package com.aws_project.chatbot.board.repository;

import com.aws_project.chatbot.board.dto.CommentListResponseDto;
import com.aws_project.chatbot.board.entity.Board;
import com.aws_project.chatbot.board.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>, CommentRepositoryCustom {
    List<CommentListResponseDto> findAllByBoard_Id(Long boardid);
}
