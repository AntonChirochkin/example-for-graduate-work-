package com.example.exampleforgraduatework.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.example.exampleforgraduatework.dto.comment.CommentDTO;
import com.example.exampleforgraduatework.dto.comment.CreateOrUpdateComment;
import com.example.exampleforgraduatework.service.CommentService;

import java.util.List;

//@Slf4j
//@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("ads")
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    private final CommentService commentService;

    //Получение комментариев объявления
    @GetMapping("/{id}/comments")
    public List<CommentDTO> getAllComments() {
        logger.info("get all comments");
        return commentService.getAllComments();
    }

    //Добавление комментария к объявлению
    @PostMapping("/{id}/comments")
    public void addComment(@PathVariable("id") Integer adId, @RequestBody CreateOrUpdateComment createOrUpdateComment) {
        logger.info("add new comment");
        commentService.addComment(adId, createOrUpdateComment);
    }

    //Удаление комментария
    @DeleteMapping("/{adId}/comments/{commentId}")
    public void deleteComment(@PathVariable("adId") Integer adId, @PathVariable("commentId") Integer commentId) {
        logger.info("delete comment");
        commentService.deleteComment(adId,commentId);
    }

    //Обновление комментария
    @PutMapping("/{adId}/comments/{commentId}")
    public void updateComment(@PathVariable("adId") Integer adId, @PathVariable("commentId") Integer commentId) {
        logger.info("update comment");
        commentService.updateComment(adId,commentId);
    }
}
