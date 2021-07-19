package com.sparta.eng87.spartaglobal_vhswebsite.controller;
import com.sparta.eng87.spartaglobal_vhswebsite.services.FilmService;
import com.sparta.eng87.spartaglobal_vhswebsite.services.HomePageFilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    private FilmService filmService;
    private HomePageFilmsService homePageFilmsService;

    @Autowired
    public HomeController(FilmService filmService, HomePageFilmsService homePageFilmsService){
        this.filmService=filmService;
        this.homePageFilmsService = homePageFilmsService;
    }


   @GetMapping("/")
    public String getVHSForDisplay(Model model){

         model.addAttribute("recentVHS", homePageFilmsService.getRecentlyUpdated());
         model.addAttribute("returnedVHS",homePageFilmsService.getMostRecentReturns());
         model.addAttribute("popularVHS",homePageFilmsService.getMostPopular());

        return "index";

    }




}
