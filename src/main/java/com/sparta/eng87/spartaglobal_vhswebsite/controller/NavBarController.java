package com.sparta.eng87.spartaglobal_vhswebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NavBarController {


    private VHSService vhsService;

    @Autowired
    public NavBarController(VHSService vhsService){
        this.vhsService=vhsService;
    }


    @GetMapping("/home")
    public String navBarHome(){
        return "/";
    }

    @GetMapping("/login")
    public String navBarLogin(){
        return"login";
    }

    @GetMapping("/about")
    public String navBarLogin(){
        return"about";
    }

    @PostMapping("/search")
    public String navBarSearch(@RequestParam(name = "search") String title, @RequestParam(name = "box") String box,Model model ){

        switch(box) {
            case "title":
                model.addAttribute("VHS", vhsService.findByTitle);
                break;
            case "actor":
                model.addAttribute("VHS", vhsService.findByActor);
                break;
            case "genre":
                model.addAttribute("VHS", vhsService.findByGenre);
                break;
        }

        return "results";
    }


}
