package com.sparta.eng87.spartaglobal_vhswebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private FilmService filmService;

    @Autowired
    public UserController(FilmService filmService){
        this.filmService=filmService;
    }

    @GetMapping("/user/{id}")
    public String userPage(@PathVariable("id") Integer id, Model model)
    {
        model.addAttribute("currentlyRented", filmService.findCurrenltyRented);
        model.addAttribute("previouslyRented", filmService.findpreviouslyRented);
        return "user";
    }


}
