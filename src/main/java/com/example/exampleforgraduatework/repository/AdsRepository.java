package com.example.exampleforgraduatework.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.exampleforgraduatework.dto.ads.Ads;
import com.example.exampleforgraduatework.entity.Ad;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdsRepository extends CrudRepository<Ad, Integer> {


//    @Query(value = "SELECT * FROM ads", nativeQuery = true)
//    List<Ad> findAllAds();
//
//    Optional<Ad> findAdById(int id);
//
//    @Query("SELECT new com.example.exampleforgraduatework.dto.ads" +
//            ".Ads(SELECT * FROM Ad a WHERE a.user.id = :userId)")
//    Ads findAdsByAuthorizedUser(int userId);

}
