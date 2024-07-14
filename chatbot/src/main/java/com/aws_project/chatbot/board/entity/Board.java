package com.aws_project.chatbot.board.entity;

import com.aws_project.chatbot.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@SQLRestriction("is_deleted = 0")
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

    @Builder.Default
    @OneToMany(mappedBy = "board")
    private List<Comment> commentList = new ArrayList<>();


}
