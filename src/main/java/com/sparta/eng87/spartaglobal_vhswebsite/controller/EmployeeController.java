package com.sparta.eng87.spartaglobal_vhswebsite.controller;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.CustomerEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.FilmEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.services.CustomerService;
import com.sparta.eng87.spartaglobal_vhswebsite.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    // TODO add in the other functions a employee will have


    private FilmService filmService;
    private CustomerService customerService;

    @Autowired
    public EmployeeController(FilmService filmService, CustomerService customerService){
        this.filmService=filmService;
        this.customerService =customerService;
    }

    @PostMapping("/addFilm")
    public void addVHS(FilmEntity filmEntity, Model model){
        filmService.save(filmEntity);
    }

    @PostMapping("/addCustomer")
    public void addCustomer(CustomerEntity customerEntity, Model model){
        customerService.save(customerEntity);
    }




}
