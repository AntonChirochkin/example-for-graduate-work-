package com.example.exampleforgraduatework.dto.ads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.exampleforgraduatework.entity.Ad;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdDTO {
    private int pk;
    private int author;
    private String title;
    private int price;
    private String image;

    public static AdDTO fromAd(Ad ad){
        AdDTO adDTO = new AdDTO();
        adDTO.setPk(ad.getPk());
        adDTO.setAuthor(ad.getUser().getId());
        adDTO.setTitle(ad.getTitle());
        adDTO.setPrice(ad.getPrice());
        Optional.ofNullable(ad.getImage()).ifPresent(image -> adDTO.setImage(
                "/ads/" + ad.getImage().getId() + "/image"));
        return adDTO;
    }
}