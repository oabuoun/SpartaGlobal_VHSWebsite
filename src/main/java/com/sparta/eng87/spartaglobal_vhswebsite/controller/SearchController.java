package com.sparta.eng87.spartaglobal_vhswebsite.controller;
import com.sparta.eng87.spartaglobal_vhswebsite.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SearchController {


    private FilmService filmService;

    @Autowired
    public SearchController(FilmService filmService){
        this.filmService=filmService;
    }


    // needs refinement depending on ui and query teams
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

        // TODO check the ordering of the inputs
        model("filteredResults", filmService.filter(genre,language,actor,title));

        return "resuts"


    }



}
