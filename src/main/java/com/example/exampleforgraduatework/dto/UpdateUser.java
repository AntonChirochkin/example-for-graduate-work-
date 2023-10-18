package com.example.exampleforgraduatework.dto;

import com.example.exampleforgraduatework.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUser {
    private String firstName;
    private String lastName;
    private String phone;


}
