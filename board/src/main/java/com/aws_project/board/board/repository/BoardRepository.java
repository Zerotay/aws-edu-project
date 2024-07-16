package com.aws_project.board.board.repository;

import com.aws_project.board.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {
//    public List<Board> findAllBy;
}
