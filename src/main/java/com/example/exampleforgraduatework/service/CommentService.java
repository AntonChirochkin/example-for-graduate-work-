package com.example.exampleforgraduatework.service;

import org.springframework.security.core.Authentication;
import com.example.exampleforgraduatework.dto.comment.CommentDTO;
import com.example.exampleforgraduatework.dto.comment.Comments;
import com.example.exampleforgraduatework.dto.comment.CreateOrUpdateComment;

/**
 * Интерфейс с методами получения, добавления, изменения, удаления комментариев к объявлениям.
 */

public interface CommentService {

    Comments getComments(Integer adId, Authentication authentication);

    CommentDTO addComment(Integer id, CreateOrUpdateComment createOrUpdateComment, Authentication authentication);

    void deleteComment(Integer adId, Integer commentId, Authentication authentication);

    CommentDTO updateComment(Integer adId, Integer commentId,CreateOrUpdateComment createOrUpdateComment, Authentication authentication);
}
