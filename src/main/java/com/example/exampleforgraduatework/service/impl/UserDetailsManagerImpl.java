package com.example.exampleforgraduatework.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import com.example.exampleforgraduatework.dto.user.AdsUserDetails;
import com.example.exampleforgraduatework.entity.Users;
import com.example.exampleforgraduatework.exceptions.UserNotFoundException;
import com.example.exampleforgraduatework.repository.UsersRepository;

public class UserDetailsManagerImpl implements UserDetailsManager {

    private final UsersRepository usersRepository;

    public UserDetailsManagerImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void createUser(UserDetails user) {
        AdsUserDetails userDetails = (AdsUserDetails) user;
        Users users = userDetails.toAdsUserDetails();
        usersRepository.save(users);
    }

    @Override
    public void updateUser(UserDetails user) {
        AdsUserDetails userDetails = (AdsUserDetails) user;
        Users users = userDetails.toAdsUserDetails();
        usersRepository.save(users);
    }

    @Override
    public void deleteUser(String username) {
        Users user = usersRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        usersRepository.delete(user);
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
//дописать
    }

    @Override
    public boolean userExists(String username) {
        Users userNotExists = new Users();
        Users users = usersRepository.findByUsername(username).orElse(userNotExists);
        return !userNotExists.equals(users);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        return AdsUserDetails.from(users);
    }
}
