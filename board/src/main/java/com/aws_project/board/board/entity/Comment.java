package com.aws_project.board.board.entity;

import com.aws_project.board.board.dto.CommentUpdateRequestDto;
import com.aws_project.board.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.SQLDelete;

@Entity
@Getter
@Builder
@SQLRestriction("is_deleted = 0")
@SQLDelete(sql = "update Comment set is_deleted=1 where id = ?")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment  extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String password;
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
    private String content;

    public static Comment update(Comment comment, CommentUpdateRequestDto commentUpdateRequestDto) {
        return Comment.builder()
                .id(comment.getId())
                .nickname(comment.getNickname())
                .password(comment.getPassword())
                .board(comment.getBoard())
                .content(commentUpdateRequestDto.getContent())
                .build();
    }
}