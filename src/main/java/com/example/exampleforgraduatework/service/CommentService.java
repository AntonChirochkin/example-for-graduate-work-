package com.example.exampleforgraduatework.service;

import com.example.exampleforgraduatework.dto.comment.CommentDTO;
import com.example.exampleforgraduatework.dto.comment.CreateOrUpdateComment;

import java.util.List;

public interface CommentService {

    List<CommentDTO> getAllComments();

    void addComment(Integer id, CreateOrUpdateComment createOrUpdateComment);

    void deleteComment(Integer adId, Integer commentId);

    void updateComment(Integer adId, Integer commentId);
}
