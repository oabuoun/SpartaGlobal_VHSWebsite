package com.sparta.eng87.spartaglobal_vhswebsite.controller;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.FilmEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.RentalEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.services.RentalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RentalController {

    private RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping("/rent")
    public void saveRental (FilmEntity filmEntity) {

        System.out.println(filmEntity.getTitle());
        rentalService.saveRental(filmEntity);
    }
}
