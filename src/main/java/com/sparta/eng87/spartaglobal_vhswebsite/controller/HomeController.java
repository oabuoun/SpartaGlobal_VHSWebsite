package com.sparta.eng87.spartaglobal_vhswebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    private VHSService vhsService;

    @Autowired
    public HomeController(VHSService vhsService){
        this.vhsService=vhsService;
    }


   @GetMapping("/")
    public String getVHSForDisplay(Model model){

        model.addAttribute("popularVHS", vhsService.findPopular);
        model.addAttribute("returnedVHS",vhsService.findReturned);
       model.addAttribute("recentVHS",vhsService.findByRecent);

        return "index";

    }




}
