package com.example.exampleforgraduatework.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.exampleforgraduatework.entity.Image;

/**
 * Хранилище для получения методов работы с базой данных изображений пользователя.
 */
public interface ImageRepository extends CrudRepository<Image, String> {
}
