package com.example.exampleforgraduatework.controller;


import com.example.exampleforgraduatework.dto.comment.UpdateImage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.example.exampleforgraduatework.dto.*;
import com.example.exampleforgraduatework.service.UserService;


@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/set_password")
    public void updatePassword(@RequestBody NewPassword newPassword) {
        userService.updatePassword(newPassword);
    }

    @GetMapping("/me")
    public User getInformation() {
        return userService.getInformation();
    }

    @PatchMapping("/me")
    public UpdateUser updateInformationAboutUser(@RequestBody UpdateUser updateUser) {
        return userService.updateInformationAboutUser(updateUser);
    }

    @PatchMapping("/me/image")
    public void updateImage(UpdateImage image) {
        userService.UpdateImage(image.getNewImage());
    }


}
