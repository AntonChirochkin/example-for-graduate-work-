package com.example.exampleforgraduatework.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.exampleforgraduatework.entity.Users;
import java.util.Optional;
/**
 * Репозиторий для получения методов работы с базой данных пользователя.
 */
@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {
    Optional<Users> findByUsername(String username);

}
