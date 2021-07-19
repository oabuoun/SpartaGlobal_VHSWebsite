package com.sparta.eng87.spartaglobal_vhswebsite.controller;
import com.sparta.eng87.spartaglobal_vhswebsite.POJO.AdvancedSearchTerms;
import com.sparta.eng87.spartaglobal_vhswebsite.POJO.SearchTerms;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.ActorEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.CategoryEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.services.FilmService;
import com.sparta.eng87.spartaglobal_vhswebsite.services.FilterService;
import com.sparta.eng87.spartaglobal_vhswebsite.services.StockCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class SearchController {


    private FilmService filmService;
    private StockCheckerService stockCheckerService;
    private FilterService filterService;

    @Autowired
    public SearchController(FilmService filmService, StockCheckerService stockCheckerService,FilterService filterService){
        this.filmService=filmService;
        this.stockCheckerService=stockCheckerService;
        this.filterService=filterService;
    }


    @PostMapping("/refine")
    public String refineSearch(@RequestParam(name = "actors", required = false)String[] actors,
                               @RequestParam(name= "genres",required = false) String[] genres,
                               @RequestParam(name = "language", required = false) String language,
                               Model model){


        List<String> actorsList=new ArrayList<>();
        List<String> genresList=new ArrayList<>();
        if (actors==null){ for (ActorEntity actor:
                filterService.getAllActors()) {
            actorsList.add(actor.getFirstName()+actor.getLastName());
        }}
        else {
            for (String currentActor :
                    actors) {
                actorsList.add(currentActor);
            }
        }


        if (genres==null){
            for (CategoryEntity genre:
                    filterService.getAllGenres()) {
                genresList.add(genre.getName());
            }

        }
        else{
            for (String currentGenre:
                    genres) {
             genresList.add(currentGenre);
            }
        }

       String title= SearchTerms.getTitle();

        model.addAttribute("inStock",stockCheckerService.isInStock(filmService.filter(actorsList,title,genresList)));
        model.addAttribute("films", filmService.filter(actorsList,title,genresList));
        model.addAttribute("actors",filterService.getAllActors());
        model.addAttribute("genres",filterService.getAllGenres());

        return "resultsPage";


    }



}
