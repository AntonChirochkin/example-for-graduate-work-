package com.example.exampleforgraduatework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.exampleforgraduatework.dto.ads.AdDTO;
import com.example.exampleforgraduatework.dto.ads.Ads;
import com.example.exampleforgraduatework.dto.ads.CreateOrUpdateAd;
import com.example.exampleforgraduatework.dto.ads.ExtendedAd;
import com.example.exampleforgraduatework.service.AdsService;


@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RequiredArgsConstructor
@RestController
@RequestMapping("/ads")
public class AdsController {

    private final AdsService adsService;

    /** Получение всех объявлений  */
    @GetMapping()
    public Ads getAllAds(){
        return adsService.getAllAds();
    }

    /** Добавление объявления */
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AdDTO> addAd(@RequestPart("properties") CreateOrUpdateAd properties,
                                       @RequestPart("image") MultipartFile image,
                                       Authentication authentication){
        return ResponseEntity.ok(adsService.addAd(properties, image, authentication));
    }

    /** Получение информации об объявлении */
    @GetMapping("/{id}")
    public ExtendedAd getAds(@PathVariable int id, Authentication authentication) {
        return adsService.getAds(id, authentication);
    }

    /**  Удаление объявления */
    @DeleteMapping("/{id}")
    public void removeAd (@PathVariable int id, Authentication authentication){
        adsService.removeAd(id, authentication);

    }

    /** Обновление информации об объявлении  */
    @PatchMapping("/{id}")
    public AdDTO updateAds(@PathVariable int id,
                           @RequestBody CreateOrUpdateAd updateAd,
                           Authentication authentication){
        return adsService.updateAds(id, updateAd, authentication);
    }

    /** Получение объявлений авторизованного пользователя */
    @GetMapping("/me")
    public Ads getAdsMe(Authentication authentication){
        return adsService.getAdsMe(authentication);
    }

    /**    Обновление картинки объявления   */
    @PatchMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<byte []> updateImage(@PathVariable int id,
                                               @RequestPart("image") MultipartFile image,
                                               Authentication authentication){
        adsService.updateImage(id, image, authentication);
        return ResponseEntity.ok().build();
    }


    @GetMapping(value ="/{id}/image", produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_GIF_VALUE, "image/*"})
    public byte [] getImage(@PathVariable("id") String id) {
        return adsService.getImage(id);
    }

}