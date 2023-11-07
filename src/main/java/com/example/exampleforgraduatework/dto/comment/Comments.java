package com.example.exampleforgraduatework.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

/**
 * Класс-обертка для получения списка комментариев к объявлению и их количества.
 */

@Data
@AllArgsConstructor
public class Comments {

    private Integer count;
    private List<CommentDTO> results;

}
