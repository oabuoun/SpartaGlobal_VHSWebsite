package com.sparta.eng87.spartaglobal_vhswebsite.controller;

import com.sparta.eng87.spartaglobal_vhswebsite.services.FilmService;
import com.sparta.eng87.spartaglobal_vhswebsite.services.StockCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResultsController {

    private FilmService filmService;
    private StockCheckerService stockCheckerService;

    @Autowired
    public ResultsController(FilmService filmService, StockCheckerService stockCheckerService) {
        this.filmService = filmService;
        this.stockCheckerService = stockCheckerService;
    }

    @PostMapping("/filteredSearch")
    public String filteredSearch(@RequestParam(name = "filterSearch") String search, @RequestParam(name = "filterSearchBy") String box, Model model) {

        switch (box) {
            case "title":
                model.addAttribute("inStock", stockCheckerService.isInStock(filmService.filterFilmsByTitle(search)));
                model.addAttribute("films", filmService.filterFilmsByTitle(search));
                break;
            case "actor":

                model.addAttribute("inStock", stockCheckerService.isInStock(filmService.filterFilmsByActor(search)));
                model.addAttribute("films", filmService.filterFilmsByActor(search));
                break;
            case "genre":
                model.addAttribute("inStock", stockCheckerService.isInStock(filmService.filterFilmsByGenre(search)));
                model.addAttribute("films", filmService.filterFilmsByGenre(search));
                break;
        }

        return "resultsPage";
    }
}
