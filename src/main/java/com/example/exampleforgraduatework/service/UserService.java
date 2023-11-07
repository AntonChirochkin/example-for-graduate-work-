package com.example.exampleforgraduatework.service;

import org.springframework.web.multipart.MultipartFile;
import com.example.exampleforgraduatework.dto.user.ImageDTO;
import com.example.exampleforgraduatework.dto.user.NewPassword;
import com.example.exampleforgraduatework.dto.user.UpdateUser;
import com.example.exampleforgraduatework.dto.user.User;

/**
 * Интерфейс со способами обновления и получения учетной записи пользователя.
 */
public interface UserService {
    void updatePassword(NewPassword newPassword, String username);
    User getInformation(String username);
    UpdateUser updateInformationAboutUser(UpdateUser updateUser, String username);
    ImageDTO updateImage (MultipartFile file, String username);

    byte [] getImage (String id);

}
