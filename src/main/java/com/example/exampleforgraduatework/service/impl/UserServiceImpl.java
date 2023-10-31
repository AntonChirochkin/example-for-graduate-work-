package com.example.exampleforgraduatework.service.impl;

import org.springframework.stereotype.Service;
import com.example.exampleforgraduatework.dto.user.NewPassword;
import com.example.exampleforgraduatework.dto.Role;
import com.example.exampleforgraduatework.dto.user.UpdateUser;
import com.example.exampleforgraduatework.dto.user.User;
import com.example.exampleforgraduatework.entity.Users;
import com.example.exampleforgraduatework.exceptions.WrongCurrentPasswordException;
import com.example.exampleforgraduatework.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final Users users = new Users(1,
            "user@gmail.com",
            "path-for-image",
            "user@gmail.com",
            "password",
            "ivan",
            "ivanov",
            "+7(777)-777-77-77",
            Role.USER);


    @Override
    public void updatePassword(NewPassword newPassword) {
        if (!newPassword.getCurrentPassword().equals(users.getPassword())) {
            throw new WrongCurrentPasswordException();
        }
    }

    @Override
    public User getInformation() {
        return User.toUser(users);
    }

    @Override
    public UpdateUser updateInformationAboutUser(UpdateUser updateUser) {
        return UpdateUser.toUpdateUser(users);
    }

    @Override
    public void UpdateImage(String image) {
//        users.setImage(image);
    }
}
