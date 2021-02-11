package com.jupiterspring.springblog.repositories;

import com.jupiterspring.springblog.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// object and data type of id, Jpa expects long so long is set for Ad id
public interface AdRepository extends JpaRepository<Ad, Long> {

    Ad findAdByTitle(String title);
    // the auto complete on this thing is crazy, will basically write the corresponding query for you

    List<Ad> findByOrderByTitle();
    // not auto complete but will work, looking at examples


    // ======== HQL SYNTAX ========= the ?1 for first param, ?2 ... ?3
    @Query("from Ad a where a.id like %:id%") // or like this, best practice over one below // is a prepared statement already
    Ad getOtherId(@Param("id") long id);


    @Query("from Ad a where a.id like ?1")
    Ad getAdById(long id);

    @Query("select title from Ad where LENGTH(title) < 15")
    List<String> getAdsOfCertainTitleLen();


    // ======= NORMAL SQL ========
    @Query(nativeQuery = true, value = "select title from adlister_db.ads where length(title) < 15") // still a prepared statement, the @Query annotation
    List<String> getAdsNativeQuery();

}
