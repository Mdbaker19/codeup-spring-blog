package com.jupiterspring.springblog.controllers;

import com.jupiterspring.springblog.model.Ad;
import com.jupiterspring.springblog.repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdController {

    // create instance of ads dao
    private final AdRepository adsDao;

    public AdController(AdRepository adsDao){
        this.adsDao = adsDao;
    }

    @GetMapping("/ads/jpa")
    @ResponseBody
    public List<Ad> jpaIndex(){
        return adsDao.findAll();
    }

//    @GetMapping("/ads/jps/{id}")
//    @ResponseBody
//    public String viewJpaAd(@PathVariable long id) {
//        return adsDao.getOne(id).toString();
//    }

    @GetMapping("/ads/{id}")
    public String viewAd(@PathVariable long id, Model model) {
        Ad myAd = adsDao.getOne(id);
        model.addAttribute("ad", myAd);
        return "ads/show";
    }


    @GetMapping("/ads/jps/create")
    public void createAd(){
        Ad ad = new Ad();
        //info from form
        ad.setTitle("this sale");
        ad.setDescription("like this");
        adsDao.save(ad);
    }

    @GetMapping("/ads/jps/delete")
    public void deleteAd(){
        adsDao.deleteById(5L);
    }

    @GetMapping("/ads/search")
    @ResponseBody
    public Ad returnAdByTitle(){
        return adsDao.findAdByTitle("this sale");
    }

    @GetMapping("/ads/order")
    @ResponseBody
    public List<Ad> returnAdsByTitle(){
        return adsDao.findByOrderByTitle();
    }

}
