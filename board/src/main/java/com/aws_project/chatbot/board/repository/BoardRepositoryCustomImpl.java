package com.aws_project.chatbot.board.repository;

import com.aws_project.chatbot.board.dto.BoardListRequestDto;
import com.aws_project.chatbot.board.dto.BoardListResponseDto;
import com.aws_project.chatbot.board.entity.QBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.aws_project.chatbot.board.entity.QBoard.board;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryCustomImpl implements BoardRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

//    private Long id;
//    private String title;
//    private String nickname;
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    private LocalDateTime createdAt;

    @Override
    public Page<BoardListResponseDto> searchBoardCustom(BoardListRequestDto boardListRequestDto, Pageable pageable) {
//        QBoard board = QBoard.board;
        List<BoardListResponseDto> result = jpaQueryFactory
                .select(Projections.constructor(BoardListResponseDto.class,
                        board.id,
                        board.title,
                        board.nickname,
                        board.createdAt
                ))
                .from(board)
                .where(
                        eqNickname(boardListRequestDto.getNickname()),
                        eqTitle(boardListRequestDto.getTitle())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return new PageImpl<>(result, pageable, result.size());
    }

    private BooleanExpression eqNickname(String nickname){
        if (!StringUtils.hasText(nickname)){
            return null;
        }
        return board.nickname.contains(nickname);
    }

    private BooleanExpression eqTitle(String title){
        if (!StringUtils.hasText(title)){
            return null;
        }
        return board.title.contains(title);
    }
}
