package com.example.exampleforgraduatework.entity;

import lombok.*;
import com.example.exampleforgraduatework.dto.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
// данный класс = entity
public class Users {
    private Integer id;
    private String email;
    private String image;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private Role role;
}
