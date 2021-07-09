package com.sparta.eng87.spartaglobal_vhswebsite.controller;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.FilmEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.RentalEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.repositories.LoginRepository;
import com.sparta.eng87.spartaglobal_vhswebsite.services.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.coyote.Request;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RentalController {

    private RentalService rentalService;
    private FilmService filmService;
    private StockCheckerService stockCheckerService;
    private LoginRepository loginRepository;
    private HomePageFilmsService homePageFilmsService;
    public RentalController(RentalService rentalService, FilmService filmService,StockCheckerService stockCheckerService, LoginRepository loginRepository, HomePageFilmsService homePageFilmsService) {
        this.filmService = filmService;
        this.rentalService = rentalService;
        this.stockCheckerService = stockCheckerService;
        this.loginRepository = loginRepository;
        this.homePageFilmsService = homePageFilmsService;
    }

    @PostMapping("/rent/{id}")
    public String saveRental (@PathVariable("id") Integer id , Principal principal, Model model) {

        if (principal == null) {
            return "redirect:/login";
        }
        if(loginRepository.findCustomerIdByUsername(principal.getName())!=null) {
            List<FilmEntity> film = new ArrayList<>();
            film.add(filmService.findFilmByID(id));
            Integer inventoryID = stockCheckerService.getStock(film);
            rentalService.saveRental(inventoryID, principal);
            model.addAttribute("error",false);
        }else {
            model.addAttribute("error",true);}

        model.addAttribute("recentVHS", homePageFilmsService.getRecentlyUpdated());
        model.addAttribute("returnedVHS",homePageFilmsService.getMostRecentReturns());
        model.addAttribute("popularVHS",homePageFilmsService.getMostPopular());
        return "index";
    }
}
