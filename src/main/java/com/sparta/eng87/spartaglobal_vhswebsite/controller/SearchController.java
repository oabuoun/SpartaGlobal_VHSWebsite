package com.sparta.eng87.spartaglobal_vhswebsite.controller;
import com.sparta.eng87.spartaglobal_vhswebsite.services.FilmService;
import com.sparta.eng87.spartaglobal_vhswebsite.services.StockCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SearchController {


    private FilmService filmService;
    private StockCheckerService stockCheckerService;

    @Autowired
    public SearchController(FilmService filmService, StockCheckerService stockCheckerService){
        this.filmService=filmService;
        this.stockCheckerService=stockCheckerService;
    }


    @PostMapping("/refine")
    public String refineSearch(@RequestParam(name = "genre", required = false)String genre,
                               @RequestParam(name = "language", required = false) String language,
                               @RequestParam(name = "actor", required = false) String actor,
                               @RequestParam(name = "title", required = false) String title,
                               Model model){
        if (genre == null)
        {
            genre = "";
        }
        if (language == null)
        {
            language = "";
        }
        if (actor == null)
        {
            actor = "";
        }
        if (title == null)
        {
            title = "";
        }

        model.addAttribute("inStock",stockCheckerService.isInStock(filmService.filter(genre,language,actor,title)));
        model.addAttribute("filteredResults", filmService.filter(genre,language,actor,title));

        return "resultsPage";


    }



}
