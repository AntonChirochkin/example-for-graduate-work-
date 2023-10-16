package com.example.exampleforgraduatework.service;

import com.example.exampleforgraduatework.dto.NewPassword;
import com.example.exampleforgraduatework.dto.UpdateUser;
import com.example.exampleforgraduatework.dto.User;

public interface UserService {
    void updatePassword(NewPassword newPassword);
    User getInformation();
    UpdateUser updateInformationAboutUser(UpdateUser updateUser);
    void UpdateImage(String image);
}
