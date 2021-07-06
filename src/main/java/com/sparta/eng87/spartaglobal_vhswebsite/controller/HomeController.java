package com.sparta.eng87.spartaglobal_vhswebsite.controller;
import com.sparta.eng87.spartaglobal_vhswebsite.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    private FilmService filmService;

    @Autowired
    public HomeController(FilmService filmService){
        this.filmService=filmService;
    }


   @GetMapping("/")
    public String getVHSForDisplay(Model model){

        model.addAttribute("popularVHS", filmService.findPopular);
        model.addAttribute("returnedVHS",filmService.findReturned);
       model.addAttribute("recentVHS",filmService.findByRecent);

        return "index";

    }




}
