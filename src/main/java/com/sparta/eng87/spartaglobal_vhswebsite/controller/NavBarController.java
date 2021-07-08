package com.sparta.eng87.spartaglobal_vhswebsite.controller;
import com.sparta.eng87.spartaglobal_vhswebsite.POJO.SearchTerms;
import com.sparta.eng87.spartaglobal_vhswebsite.services.FilmService;
import com.sparta.eng87.spartaglobal_vhswebsite.services.FilterService;
import com.sparta.eng87.spartaglobal_vhswebsite.services.StockCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class NavBarController {


    private FilmService filmService;
    private StockCheckerService stockCheckerService;
    private FilterService filter;


    @Autowired
    public NavBarController(FilmService filmService, StockCheckerService stockCheckerService, FilterService filter){
        this.filmService=filmService;
        this.stockCheckerService = stockCheckerService;
        this.filter=filter;
    }


    @GetMapping("/home")
    public String navBarHome(){
        return "index";
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
                model.addAttribute("actors",filter.getAllActors());
                model.addAttribute("genres",filter.getAllGenres());
        switch(box) {
            case "title":
                model.addAttribute("inStock",stockCheckerService.isInStock(filmService.findFilmsByTitle(search)));
                model.addAttribute("films", filmService.findFilmsByTitle(search));
                break;
            case "actor":
                model.addAttribute("inStock",stockCheckerService.isInStock(filmService.findFilmsByActor(search)));
                model.addAttribute("films", filmService.findFilmsByActor(search));
                break;
            case "genre":
                model.addAttribute("inStock",stockCheckerService.isInStock(filmService.findFilmsByGenre(search)));
                model.addAttribute("films", filmService.findFilmsByGenre(search));
                break;
        }
        SearchTerms.setTitle(search);

        return "resultsPage";
    }

}
