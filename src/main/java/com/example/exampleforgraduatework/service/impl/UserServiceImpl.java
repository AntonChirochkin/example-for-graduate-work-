package com.example.exampleforgraduatework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.exampleforgraduatework.dto.user.ImageDTO;
import com.example.exampleforgraduatework.dto.user.NewPassword;
import com.example.exampleforgraduatework.dto.user.UpdateUser;
import com.example.exampleforgraduatework.dto.user.User;
import com.example.exampleforgraduatework.entity.Users;
import com.example.exampleforgraduatework.entity.Image;
import com.example.exampleforgraduatework.exceptions.UserNotFoundException;
import com.example.exampleforgraduatework.exceptions.WrongCurrentPasswordException;
import com.example.exampleforgraduatework.repository.ImageRepository;
import com.example.exampleforgraduatework.repository.UsersRepository;
import com.example.exampleforgraduatework.service.UserService;
import java.io.IOException;
import java.util.Objects;

/**
 * Класс с методами для обновления и получения учетной записи пользователя.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ImageRepository imageRepository;

    /**
     * Метод обновления пароля
     */
    @Override
    public void updatePassword(NewPassword newPassword, String username) {
        Users users = usersRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        if (passwordEncoder.matches(newPassword.getCurrentPassword(), users.getPassword())) {
            users.setPassword(passwordEncoder.encode(newPassword.getNewPassword()));
            usersRepository.save(users);
        } else {
            throw new WrongCurrentPasswordException();
        }
    }
    /**
     * Способ получения информации об учетной записи пользователя.
     */
    @Override
    public User getInformation(String username) {
        Users users = usersRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        return User.toUser(users);
    }

    /**
     * Способ обновления информации (имя, фамилия и телефон) для учетной записи пользователя.
     */
    @Override
    public UpdateUser updateInformationAboutUser(UpdateUser updateUser, String username) {
        Users users = usersRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        users.setFirstName(updateUser.getFirstName());
        users.setLastName(updateUser.getLastName());
        users.setPhone(updateUser.getPhone());
        usersRepository.save(users);
        return UpdateUser.toUpdateUser(users);
    }

    /**
     *
     * Способ обновления изображения для учетной записи пользователя.
     */
    @Override
    public ImageDTO updateImage(MultipartFile file, String username) {
        Users users = usersRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        Image image;
        if (!Objects.isNull(users.getImage())) {
            image = imageRepository.findById(users.getImage().getId()).orElse(new Image());
        } else {
            image = new Image();
            image.setId(users.getId().toString());
        }
        try {
            byte[] imageBytes = file.getBytes();
            image.setImage(imageBytes);
        } catch (IOException e) {
            throw new RuntimeException();
        }
        Image returnImage = imageRepository.save(image);
        users.setImage(image);
        usersRepository.save(users);
        return ImageDTO.fromImage(returnImage);
    }
    /**
     * Способ получения изображения для учетной записи пользователя.
     */
    @Override
    public byte[] getImage(String id) {
        Image image = imageRepository.findById(id).orElseThrow();
        return image.getImage();
    }
}
