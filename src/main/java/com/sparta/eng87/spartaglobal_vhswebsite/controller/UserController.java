package com.sparta.eng87.spartaglobal_vhswebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private VHSService vhsService;

    @Autowired
    public UserController(VHSService vhsService){
        this.vhsService=vhsService;
    }

    @GetMapping("/user/{id}")
    public String userPage(@PathVariable("id") Integer id, Model model)
    {
        model.addAttribute("currentlyRented", vhsService.findCurrenltyRented);
        model.addAttribute("previouslyRented", vhsService.findpreviouslyRented);
        return "user";
    }


}
