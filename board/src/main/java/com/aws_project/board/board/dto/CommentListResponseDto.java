package com.aws_project.board.board.dto;

import com.aws_project.board.board.entity.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentListResponseDto {
    private Long id;
    private String content;
    private String nickname;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;

    public static CommentListResponseDto toCommentListResponseDto(Comment comment){
       return CommentListResponseDto.builder()
               .id(comment.getId())
               .nickname(comment.getNickname())
               .createdAt(comment.getCreatedAt())
               .build();
    }
}
