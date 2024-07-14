package com.aws_project.chatbot.board.dto;

import com.aws_project.chatbot.board.entity.Board;
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
public class BoardListResponseDto {
    private Long id;
    private String title;
    private String nickname;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;

    public static BoardListResponseDto toBoardListResponseDto(Board board){
       return BoardListResponseDto.builder()
               .id(board.getId())
               .title(board.getTitle())
               .nickname(board.getNickname())
               .createdAt(board.getCreatedAt())
               .build();
    }
}
