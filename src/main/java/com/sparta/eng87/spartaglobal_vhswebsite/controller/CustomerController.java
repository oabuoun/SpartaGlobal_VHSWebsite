package com.sparta.eng87.spartaglobal_vhswebsite.controller;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.LoginEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.services.CustomerService;
import com.sparta.eng87.spartaglobal_vhswebsite.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

import java.security.Principal;

@Controller
public class CustomerController {

    private FilmService filmService;
    private CustomerService customerService;

    @Autowired
    public CustomerController(FilmService filmService, CustomerService customerService){
        this.filmService=filmService;
        this.customerService=customerService;
    }

    @GetMapping("/user")
    public String userPage(Principal principal, Model model)
    {
        String username = principal.getName();
        Integer customerId = customerService.findCustomerIdByUsername(username);

        model.addAttribute("currentlyRented", customerService.getCurrentlyRentedFilmsByCustomerId(customerId));
        model.addAttribute("previouslyRented", customerService.getPreviouslyRentedFilmsByCustomerId(customerId));
        model.addAttribute("username", username);
        return "userPage";
    }


}
