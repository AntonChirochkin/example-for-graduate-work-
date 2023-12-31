package com.example.exampleforgraduatework.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.exampleforgraduatework.dto.Register;
import com.example.exampleforgraduatework.entity.Users;
import com.example.exampleforgraduatework.exceptions.UserNotFoundException;
import com.example.exampleforgraduatework.repository.UsersRepository;

/**
 * Класс с методами для работы с аутентификацией и создания новой учетной записи пользователя.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsersRepository usersRepository;


    public UserDetailsServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * Способ поиска пользователя в базе данных по имени пользователя.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new AdsUserDetails(usersRepository.findByUsername(username).orElseThrow(UserNotFoundException::new));
    }

    /**
     * Существует метод проверки пользователя.
     */
    public boolean userExists(String username) {
        Users userNotExists = new Users();
        Users users = usersRepository.findByUsername(username).orElse(userNotExists);
        return !userNotExists.equals(users);
    }

    /**
     * Способ создания пользователя.
     */
    public void createUser(Register register, String password) {
        Users users = new Users();
        users.setPassword(password);
        users.setPhone(register.getPhone());
        users.setUsername(register.getUsername());
        users.setFirstName(register.getFirstName());
        users.setLastName(register.getLastName());
        users.setRole(register.getRole());
        usersRepository.save(users);
    }
}