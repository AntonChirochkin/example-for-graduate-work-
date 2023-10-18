package com.example.exampleforgraduatework.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.example.exampleforgraduatework.dto.comment.CommentDTO;
import com.example.exampleforgraduatework.dto.comment.Comments;
import com.example.exampleforgraduatework.entity.Comment;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

    @Query(value = "SELECT * FROM comments",
            nativeQuery = true)
    List<Comment> findAllComments();

    @Query(value = "SELECT * FROM comments " +
            "WHERE author_id= :author",
            nativeQuery = true)
    List<Comment> findAllCommentByAuthor(Integer author);

    @Query(value = "SELECT * FROM comments " +
            "WHERE comment_id= :pk",
            nativeQuery = true)
    Comment findCommentByCommentId(Integer pk);

    @Query("SELECT new ru.skypro.homework.dto.comment" +
            ".Comments((SELECT COUNT(c.pk) FROM Comment c), " +
            "(SELECT * FROM Comment c WHERE c.ad.adId = :adId))")
    Comments findCommentsByAdId(Integer adId);
}