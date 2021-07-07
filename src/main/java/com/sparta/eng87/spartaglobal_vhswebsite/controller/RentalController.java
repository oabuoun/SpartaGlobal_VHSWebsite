package com.sparta.eng87.spartaglobal_vhswebsite.controller;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.FilmEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.RentalEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.services.FilmService;
import com.sparta.eng87.spartaglobal_vhswebsite.services.RentalService;

import com.sparta.eng87.spartaglobal_vhswebsite.services.StockCheckerService;
import org.springframework.stereotype.Controller;
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

    public RentalController(RentalService rentalService, FilmService filmService,StockCheckerService stockCheckerService) {
        this.filmService = filmService;
        this.rentalService = rentalService;
        this.stockCheckerService = stockCheckerService;
    }

    @PostMapping("/rent/{id}")
    public String saveRental (@PathVariable("id") Integer id , Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        List<FilmEntity> film = new ArrayList<>();
        film.add(filmService.findFilmByID(id));
        Integer inventoryID = stockCheckerService.getStock(film);
        rentalService.saveRental(inventoryID, principal);

        return "redirect:/";
    }
}
