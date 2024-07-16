package com.aws_project.board.board.repository;


import com.aws_project.board.board.dto.CommentListResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.aws_project.board.board.entity.QComment.comment;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryCustomImpl implements CommentRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<CommentListResponseDto> searchCustom(Long boardId) {
        return jpaQueryFactory.select(Projections.constructor(CommentListResponseDto.class,
                        comment.id,
                        comment.content,
                        comment.nickname,
                        comment.createdAt
                )).from(comment)
                .where(
                        comment.board.id.eq(boardId)
                )
                .fetch();
    }
}
