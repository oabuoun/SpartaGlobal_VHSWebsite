package com.sparta.eng87.spartaglobal_vhswebsite.controller;
import com.sparta.eng87.spartaglobal_vhswebsite.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    private FilmService filmService;

    @Autowired
    public CustomerController(FilmService filmService){
        this.filmService=filmService;
    }

    @GetMapping("/user/{id}")
    public String userPage(@PathVariable("id") Integer id, Model model)
    {
        // TODO add correct method signature
        //model.addAttribute("currentlyRented", filmService.findCurrenltyRented(id));
      /*  model.addAttribute("previouslyRented", filmService.findpreviouslyRented(id));  low priority */
        return "user";
    }


}
