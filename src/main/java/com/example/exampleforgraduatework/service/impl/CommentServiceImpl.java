package com.example.exampleforgraduatework.service.impl;

import com.example.exampleforgraduatework.dto.comment.CommentDTO;
import com.example.exampleforgraduatework.dto.comment.CreateOrUpdateComment;
import com.example.exampleforgraduatework.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {


    @Override
    public List<CommentDTO> getComments(Integer adId) {
        return null;
    }

    @Override
    public void addComment(Integer id, CreateOrUpdateComment createOrUpdateComment) {

    }

    @Override
    public void deleteComment(Integer adId, Integer commentId) {

    }

    @Override
    public void updateComment(Integer adId, Integer commentId) {

    }
}
