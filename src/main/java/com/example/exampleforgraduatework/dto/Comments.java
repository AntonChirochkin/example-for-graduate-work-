package com.example.exampleforgraduatework.dto;

import lombok.Data;

import java.util.List;

@Data
public class Comments {

    private int count;
    private List<CommentDTO> results;

}
