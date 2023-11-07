package com.example.exampleforgraduatework.dto.user;

import lombok.*;
import com.example.exampleforgraduatework.dto.Role;
import com.example.exampleforgraduatework.entity.Users;
import java.util.Optional;

/**
 * Класс-обёртка для вывода данных в профиле пользователя
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private Role role;
    private String image;

    /**
     * Метод сопоставления сущностей Users с классом-берткой для получения данных в профиле пользователя
     */
    public static User toUser(Users users) {
        User user = new User();
        user.setId(users.getId());
        user.setEmail(users.getUsername());
        user.setPhone(users.getPhone());
        user.setFirstName(users.getFirstName());
        user.setLastName(users.getLastName());
        user.setRole(users.getRole());
        Optional.ofNullable(users.getImage()).ifPresent(image -> user.setImage(
                "/users/" + users.getImage().getId() + "/image"));
        return user;
    }
}
