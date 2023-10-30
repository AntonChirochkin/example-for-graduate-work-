package com.example.exampleforgraduatework.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.exampleforgraduatework.dto.Role;
import com.example.exampleforgraduatework.dto.user.NewPassword;
import com.example.exampleforgraduatework.dto.user.UpdateUser;
import com.example.exampleforgraduatework.dto.user.User;
import com.example.exampleforgraduatework.entity.Users;
import com.example.exampleforgraduatework.exceptions.UserNotFoundException;
import com.example.exampleforgraduatework.exceptions.WrongCurrentPasswordException;
import com.example.exampleforgraduatework.repository.UsersRepository;
import com.example.exampleforgraduatework.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public void updatePassword(NewPassword newPassword, Integer id) {
        Users users = usersRepository.findById(id).orElseThrow(UserNotFoundException::new);
        if (!newPassword.getCurrentPassword().equals(users.getPassword())) {
            throw new WrongCurrentPasswordException();
        }
        users.setPassword(newPassword.getNewPassword());
        usersRepository.save(users);
    }

    @Override
    public User getInformation(Integer id) {
        Users users = usersRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return User.toUser(users);
    }

    @Override
    public UpdateUser updateInformationAboutUser(UpdateUser updateUser, Integer id) {
        Users users = usersRepository.findById(id).orElseThrow(UserNotFoundException::new);
        users.setFirstName(updateUser.getFirstName());
        users.setLastName(updateUser.getLastName());
        users.setPhone(updateUser.getPhone());
        usersRepository.save(users);
        return UpdateUser.toUpdateUser(users);
    }

    @Override
    public void UpdateImage(MultipartFile file, Integer id) {
        Users users = usersRepository.findById(id).orElseThrow(UserNotFoundException::new);
//        дописать логику работы с файлами

    }
}
