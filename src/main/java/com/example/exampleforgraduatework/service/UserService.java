package com.example.exampleforgraduatework.service;

import org.springframework.web.multipart.MultipartFile;
import com.example.exampleforgraduatework.dto.user.NewPassword;
import com.example.exampleforgraduatework.dto.user.UpdateUser;
import com.example.exampleforgraduatework.dto.user.User;

public interface UserService {
    void updatePassword(NewPassword newPassword);
    User getInformation();
    UpdateUser updateInformationAboutUser(UpdateUser updateUser);
    void UpdateImage(String image);


}
