package com.example.exampleforgraduatework.service;

import org.springframework.web.multipart.MultipartFile;
import com.example.exampleforgraduatework.dto.user.NewPassword;
import com.example.exampleforgraduatework.dto.user.UpdateUser;
import com.example.exampleforgraduatework.dto.user.User;

public interface UserService {
    void updatePassword(NewPassword newPassword, Integer id);
    User getInformation(Integer id);
    UpdateUser updateInformationAboutUser(UpdateUser updateUser, Integer id);
    void UpdateImage(MultipartFile file, Integer id);
}
