package com.aws_project.chatbot.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardCreateRequestDto {
    private String nickname;
    private String password;
    private String title;
    private String content;

}
