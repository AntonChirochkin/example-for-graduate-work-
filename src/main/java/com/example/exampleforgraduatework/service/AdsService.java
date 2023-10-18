package com.example.exampleforgraduatework.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.exampleforgraduatework.dto.ads.AdDTO;
import com.example.exampleforgraduatework.dto.ads.Ads;
import com.example.exampleforgraduatework.dto.ads.CreateOrUpdateAd;
import com.example.exampleforgraduatework.dto.ads.ExtendedAd;


public interface AdsService {
    Ads getAllAds();
    AdDTO addAd(CreateOrUpdateAd createAd, MultipartFile image);
    ExtendedAd getAds(int id);
    void removeAd (int id);
    AdDTO updateAds(int id, CreateOrUpdateAd updateAd);
    Ads getAdsMe();
    String updateImage(int id,MultipartFile image);

}
