package com.aws_project.board.board.service;

import com.aws_project.board.board.entity.Board;
import com.aws_project.board.board.entity.Comment;
import com.aws_project.board.board.repository.BoardRepository;
import com.aws_project.board.board.repository.CommentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class DummyDataService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @PostConstruct
    public void createDummyData() {
        Random random = new Random();
        List<Board> boards = new ArrayList<>();
        List<Comment> comments = new ArrayList<>();

        for (int i = 1; i <= 111; i++) {
            Board board = Board.builder()
                    .content("This is the content of board " + i)
                    .nickname("user" + i)
                    .password("password" + i)
                    .title("Title " + i)
                    .build();
            boards.add(board);

            int numberOfComments = random.nextInt(7) + 4; // 4 ~ 10 comments
            for (int j = 1; j <= numberOfComments; j++) {
                Comment comment = Comment.builder()
                        .content("This is comment " + j + " on board " + i)
                        .nickname("commenter" + j)
                        .password("commentpassword" + j)
                        .board(board)
                        .build();
                comments.add(comment);
            }
        }

        boardRepository.saveAllAndFlush(boards);
        commentRepository.saveAllAndFlush(comments);
    }
}