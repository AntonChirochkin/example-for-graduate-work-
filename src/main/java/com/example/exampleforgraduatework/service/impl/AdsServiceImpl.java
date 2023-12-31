package com.example.exampleforgraduatework.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.exampleforgraduatework.dto.ads.AdDTO;
import com.example.exampleforgraduatework.dto.ads.Ads;
import com.example.exampleforgraduatework.dto.ads.CreateOrUpdateAd;
import com.example.exampleforgraduatework.dto.ads.ExtendedAd;
import com.example.exampleforgraduatework.entity.Ad;
import com.example.exampleforgraduatework.entity.ImageAd;
import com.example.exampleforgraduatework.entity.Users;
import com.example.exampleforgraduatework.exceptionHandlers.AccessErrorException;
import com.example.exampleforgraduatework.exceptionHandlers.AdNotFoundException;
import com.example.exampleforgraduatework.exceptions.UserNotFoundException;
import com.example.exampleforgraduatework.repository.AdsRepository;
import com.example.exampleforgraduatework.repository.ImageAdRepository;
import com.example.exampleforgraduatework.repository.UsersRepository;
import com.example.exampleforgraduatework.service.AdsService;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AdsServiceImpl implements AdsService {

    private final AdsRepository adsRepository;
    private final UsersRepository usersRepository;
    private final ImageAdRepository imageAdRepository;

    public AdsServiceImpl(AdsRepository adsRepository,
                          UsersRepository usersRepository,
                          ImageAdRepository imageAdRepository) {
        this.adsRepository = adsRepository;
        this.usersRepository = usersRepository;
        this.imageAdRepository = imageAdRepository;
    }


    private boolean isAdminOrOwnerAd(Authentication authentication, String ownerAd) {
        boolean isAdmin = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList())
                .contains("ROLE_ADMIN");

        boolean isOwnerAd = authentication.getName().equals(ownerAd);

        return isAdmin || isOwnerAd;

    }

    private Users userMe(Authentication authentication) {
        return usersRepository.findByUsername(authentication.getName()).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public Ads getAllAds() {

        List<Ad> adList = adsRepository.findAllAds();

        List<AdDTO> adDTOList = adList.stream()
                .map(AdDTO::fromAd)
                .collect(Collectors.toList());

        return new Ads(adDTOList);
    }

    @Override
    public AdDTO addAd(CreateOrUpdateAd properties, MultipartFile file, Authentication authentication) {

        String username = authentication.getName();
        Users user = usersRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);

        if (authentication.isAuthenticated()) {

            Ad ad = properties.toAd();
            ad.setUser(user);
            ad = adsRepository.save(ad);

            ImageAd image = new ImageAd();
            image.setId(ad.getPk().toString());

            try {
                byte[] imageBytes = file.getBytes();
                image.setImage(imageBytes);
            } catch (IOException e) {
                throw new RuntimeException();
            }
            ImageAd returnImage = imageAdRepository.save(image);
            ad.setImage(returnImage);

            AdDTO adDTO = AdDTO.fromAd(adsRepository.save(ad));

            return adDTO;

        } else {
            throw new AccessErrorException();
        }
    }

    @Override
    public ExtendedAd getAds(int id, Authentication authentication) {
        if (authentication.isAuthenticated()) {
            Ad extendedAd = adsRepository.findAdByPk(id).orElseThrow(AdNotFoundException::new);
            return ExtendedAd.fromAd(extendedAd);
        } else {
            throw new AccessErrorException();
        }
    }

    @Override
    public void removeAd(int id, Authentication authentication) {
        Ad deletedAd = adsRepository.findAdByPk(id).orElseThrow(AdNotFoundException::new);
        if (isAdminOrOwnerAd(authentication, deletedAd.getUser().getUsername())) {
            adsRepository.delete(deletedAd);
        } else {
            throw new AccessErrorException();
        }
    }

    @Override
    public AdDTO updateAds(int id, CreateOrUpdateAd updateAd, Authentication authentication) {
        Ad updatedAd = adsRepository.findAdByPk(id).orElseThrow(AdNotFoundException::new);
        if (isAdminOrOwnerAd(authentication, updatedAd.getUser().getUsername())) {
            updatedAd.setTitle(updateAd.getTitle());
            updatedAd.setPrice(updateAd.getPrice());
            updatedAd.setDescription(updateAd.getDescription());
            adsRepository.save(updatedAd);
        } else {
            throw new AccessErrorException();
        }

        return AdDTO.fromAd(updatedAd);
    }


    @Override
    public Ads getAdsMe(Authentication authentication) {
        Integer meId = userMe(authentication).getId();
        return new Ads(adsRepository.getAdsMe(meId)
                .stream()
                .map(AdDTO::fromAd)
                .collect(Collectors.toList()));
    }

    @Override
    public ImageAd updateImage(int id, MultipartFile file, Authentication authentication) {

        Ad ad = adsRepository.findAdByPk(id).orElseThrow(AdNotFoundException::new);

        if (isAdminOrOwnerAd(authentication, ad.getUser().getUsername())) {
            ImageAd image;
            if (!Objects.isNull(ad.getImage())) {
                image = imageAdRepository.findById(ad.getImage().getId()).orElse(new ImageAd());
            } else {
                image = new ImageAd();
                image.setId(ad.getPk().toString());
            }
            try {
                byte[] imageBytes = file.getBytes();
                image.setImage(imageBytes);
            } catch (IOException e) {
                throw new RuntimeException();
            }
            ImageAd returnImage = imageAdRepository.save(image);
            ad.setImage(image);
            adsRepository.save((ad));

            return returnImage;

        } else {
            throw new AccessErrorException();
        }
    }

    @Override
    public byte [] getImage (String id){
        ImageAd image = imageAdRepository.findById(id).orElseThrow();
        return image.getImage();
    }
}
