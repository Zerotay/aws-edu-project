package com.aws_project.chatbot.board.dto;

import com.aws_project.chatbot.common.enums.BoardSortBy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardListRequestDto {
    private String nickname;
    private String title;
    private BoardSortBy sort = BoardSortBy.LATEST;
//    private String page;
//    private String size;
}

