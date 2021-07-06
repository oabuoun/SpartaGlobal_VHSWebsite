package com.sparta.eng87.spartaglobal_vhswebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NavBarController {


    private FilmService filmService;

    @Autowired
    public NavBarController(FilmService filmService){
        this.filmService=filmService;
    }


    @GetMapping("/home")
    public String navBarHome(){
        return "/";
    }

    @GetMapping("/login")
    public String navBarLogin(){
        return"login";
    }

    @GetMapping("/about")
    public String navBarLogin(){
        return"about";
    }

    @PostMapping("/search")
    public String navBarSearch(@RequestParam(name = "search") String title, @RequestParam(name = "searchBy") String box,Model model ){

        switch(box) {
            case "title":
                model.addAttribute("search", filmService.findByTitle);
                break;
            case "actor":
                model.addAttribute("search", filmService.findByActor);
                break;
            case "genre":
                model.addAttribute("search", filmService.findByGenre);
                break;
        }

        return "results";
    }


}
