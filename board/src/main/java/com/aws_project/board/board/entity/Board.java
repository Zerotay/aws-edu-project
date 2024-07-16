package com.aws_project.board.board.entity;

import com.aws_project.board.board.dto.BoardUpdateRequestDto;
import com.aws_project.board.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@Builder
@SQLRestriction("is_deleted = 0")
@SQLDelete(sql = "update Board set is_deleted=1 where id = ?")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String password;
    private String title;
    private String content;

//    @Builder.Default
//    @OneToMany(mappedBy = "board")
//    private List<Comment> commentList = new ArrayList<>();

    public static Board update(Board board, BoardUpdateRequestDto boardUpdateRequestDto) {
        return Board.builder()
                .id(board.getId())
                .nickname(board.getNickname())
                .password(board.getPassword())
                .title(boardUpdateRequestDto.getTitle())
                .content(boardUpdateRequestDto.getContent())
//                .commentList(board.getCommentList())
                .build();
    }

}
