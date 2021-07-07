package com.sparta.eng87.spartaglobal_vhswebsite.controller;
import com.sparta.eng87.spartaglobal_vhswebsite.services.FilmService;
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
        return"loginPage";
    }

    @GetMapping("/about")
    public String navBarAbout(){
        return"aboutPage";
    }

    @PostMapping("/search")
    public String navBarSearch(@RequestParam(name = "search") String search, @RequestParam(name = "searchBy") String box,Model model ){

        switch(box) {
            case "title":
                model.addAttribute("films", filmService.findFilmsByTitle(search));
                break;
            case "actor":
                model.addAttribute("films", filmService.findFilmsByActor(search));
                break;
            case "genre":
                model.addAttribute("films", filmService.findFilmsByGenre(search));
                break;
        }

        return "resultsPage";
    }
}
