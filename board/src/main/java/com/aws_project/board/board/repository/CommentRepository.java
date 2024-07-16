package com.aws_project.board.board.repository;

import com.aws_project.board.board.dto.CommentListResponseDto;
import com.aws_project.board.board.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>, CommentRepositoryCustom {
    List<CommentListResponseDto> findAllByBoard_Id(Long boardid);
}
