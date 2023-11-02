package com.example.exampleforgraduatework.dto.ads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.exampleforgraduatework.entity.Ad;
import com.example.exampleforgraduatework.entity.Users;

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
        adDTO.setImage(ad.getImage());
        return adDTO;
    }

    public Ad toAd(Users user){
        Ad ad = new Ad();
        ad.setPk(this.getPk());
        ad.setUser(user);
        ad.setTitle(this.getTitle());
        ad.setPrice(this.getPrice());
        ad.setImage(this.getImage());
        return ad;
    }
}