package com.aws_project.board.board.dto;

import com.aws_project.board.common.enums.BoardSortBy;
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

