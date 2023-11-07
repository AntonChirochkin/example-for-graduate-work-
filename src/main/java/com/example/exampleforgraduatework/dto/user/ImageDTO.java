package com.example.exampleforgraduatework.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.exampleforgraduatework.entity.Image;
/**
 * Класс-оболочка для получения изображения.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageDTO {
    private String id;

    private byte [] image;

    /**
     * Метод сопоставления изображения объекта с классом-оболочкой.
     */
    public static ImageDTO fromImage(Image image) {
        return new ImageDTO(image.getId(), image.getImage());
    }
}
