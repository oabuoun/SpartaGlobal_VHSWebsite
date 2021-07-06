package com.sparta.eng87.spartaglobal_vhswebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String refineSearch(@RequestParam(name = ""))



}
