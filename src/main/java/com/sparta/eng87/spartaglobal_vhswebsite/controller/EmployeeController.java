package com.sparta.eng87.spartaglobal_vhswebsite.controller;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.CustomerEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.FilmEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.LoginEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.services.CustomerService;
import com.sparta.eng87.spartaglobal_vhswebsite.services.FilmService;
import com.sparta.eng87.spartaglobal_vhswebsite.services.LoginService;
import com.sparta.eng87.spartaglobal_vhswebsite.services.StockCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    // TODO add in the other functions a employee will have


    private FilmService filmService;
    private CustomerService customerService;
    private StockCheckerService stockCheckerService;
    private LoginService loginService;

    @Autowired
    public EmployeeController(FilmService filmService, CustomerService customerService, StockCheckerService stockCheckerService, LoginService loginService){
        this.filmService=filmService;
        this.customerService =customerService;
        this.stockCheckerService = stockCheckerService;
        this.loginService = loginService;
    }

    @GetMapping("/employee")
    public String gotoEmployeePage(){
        return "employeePage";
    }

    @PostMapping("/addFilm")
    public void addVHS(FilmEntity filmEntity, Model model){
        filmService.save(filmEntity);
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, Model model){
        LoginEntity loginEntity = new LoginEntity();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        loginEntity.setUserName(username);
        loginEntity.setUserPassword(encoder.encode(password));
        loginEntity.setUserRole("USER");
        loginEntity.setUserActivated(1);
        loginService.addUser(loginEntity);
        return "redirect:/employee";
    }

    @GetMapping("/addUser")
    public String getAddCustomerPage() {
        return "addUser";
    }

    @PostMapping("/employeeSearch")
    public String employeeSearch (@RequestParam(name = "search") String search, Model model) {
        model.addAttribute("inStock",stockCheckerService.isInStock(filmService.findFilmsByTitle(search)));
        model.addAttribute("films", filmService.findFilmsByTitle(search));
        return "employeeResults";
    }


}
