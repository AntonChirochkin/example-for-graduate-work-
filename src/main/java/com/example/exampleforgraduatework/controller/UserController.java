package com.example.exampleforgraduatework.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.example.exampleforgraduatework.dto.AdsUserDetails;
import com.example.exampleforgraduatework.dto.NewPassword;
import com.example.exampleforgraduatework.dto.UpdateUser;
import com.example.exampleforgraduatework.dto.User;
import com.example.exampleforgraduatework.service.UserService;

//@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/set_password")
    public void updatePassword(@RequestBody NewPassword newPassword) {
        userService.updatePassword(newPassword);
    }

    @GetMapping("/me")
    public User getInformation(Authentication authentication) {
        AdsUserDetails userDetails = (AdsUserDetails) authentication.getPrincipal();
        return userService.getInformation();
    }

    @PatchMapping("/me")
    public UpdateUser updateInformationAboutUser(@RequestBody UpdateUser updateUser) {
        return userService.updateInformationAboutUser(updateUser);
    }

    @PatchMapping("/me/image")
    public void updateImage(String image) {
        userService.UpdateImage(image);
    }


}
