package com.example.exampleforgraduatework.entity;

import lombok.*;
import com.example.exampleforgraduatework.dto.Role;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.*;

/**
 * Класс-сущность с пользовательскими данными в базе данных
 * Дополнительно класс используется при проверке подлинности и авторизации, реализует класс UserDetails.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "users")

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image image;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String phone;

    @Enumerated
    private Role role;

}