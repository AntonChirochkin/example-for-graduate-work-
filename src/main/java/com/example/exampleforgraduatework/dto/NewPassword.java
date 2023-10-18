package com.example.exampleforgraduatework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewPassword {
    private String currentPassword;
    private String newPassword;
}
