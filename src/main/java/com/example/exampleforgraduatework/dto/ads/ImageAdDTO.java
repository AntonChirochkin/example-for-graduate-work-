package com.example.exampleforgraduatework.dto.ads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.exampleforgraduatework.entity.ImageAd;

/**
 * Класс-обертка для получения картинки объявления.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageAdDTO {

    private String id;
    private byte[] image;

    public static ImageAdDTO fromImageAd(ImageAd image) {
        return new ImageAdDTO(image.getId(), image.getImage());
    }
}
