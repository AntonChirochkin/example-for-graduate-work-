package com.example.exampleforgraduatework.entity;

//import jakarta.validation.constraints.*;
import lombok.*;
import com.example.exampleforgraduatework.dto.Role;
import com.example.exampleforgraduatework.dto.comment.CommentDTO;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "users")

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String image;

    //    @Size(min=4, max=32)
    private String username;

    //    @Size(min=8, max=16)
    private String password;

    //    @Size(min=2, max=16)
    private String firstName;

    //    @Size(min=2, max=16)
    private String lastName;
    //    @Pattern(regexp = "\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}-?\\d{2}-?\\d{2}")
    private String phone;

    @Enumerated
    private Role role;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "users")
    private List<Comment> commentList;

}