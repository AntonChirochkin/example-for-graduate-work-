package com.example.exampleforgraduatework.service;


import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import com.example.exampleforgraduatework.dto.ads.AdDTO;
import com.example.exampleforgraduatework.dto.ads.Ads;
import com.example.exampleforgraduatework.dto.ads.CreateOrUpdateAd;
import com.example.exampleforgraduatework.dto.ads.ExtendedAd;
import com.example.exampleforgraduatework.entity.ImageAd;


public interface AdsService {
    Ads getAllAds();
    AdDTO addAd(CreateOrUpdateAd createAd, MultipartFile image, Authentication authentication);

    ExtendedAd getAds(int id, Authentication authentication);

    //    @PreAuthorize("principal.admin or #username == authentication.principal.username")
    void removeAd (int id, Authentication authentication);

    //    @PreAuthorize("principal.admin or #username == authentication.principal.username")
    AdDTO updateAds(int id, CreateOrUpdateAd updateAd, Authentication authentication);

    Ads getAdsMe(Authentication authentication);

    //    @PreAuthorize("principal.admin or #username == authentication.principal.username")
    ImageAd updateImage(int id, MultipartFile image, Authentication authentication);

    byte [] getImage (String id);

}
