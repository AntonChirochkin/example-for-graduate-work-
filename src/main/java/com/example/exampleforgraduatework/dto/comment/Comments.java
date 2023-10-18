package com.example.exampleforgraduatework.dto.comment;

import lombok.Data;

import java.util.List;

@Data
public class Comments {

    private Integer count;
    private List<CommentDTO> results;

}
