package com.example.exampleforgraduatework.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.exampleforgraduatework.entity.ImageAd;
/**
 * Хранилище для получения методов работы с базой данных изображений рекламы.
 */
public interface ImageAdRepository extends CrudRepository<ImageAd, String> {
}
