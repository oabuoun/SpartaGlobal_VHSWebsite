package com.sparta.eng87.spartaglobal_vhswebsite.controller;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.AddressEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.CustomerEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.FilmEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.entities.LoginEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.services.*;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class EmployeeController {




    private FilmService filmService;
    private CustomerService customerService;
    private StockCheckerService stockCheckerService;
    private LoginService loginService;
    private AddressService addressService;

    @Autowired
    public EmployeeController(FilmService filmService, CustomerService customerService, StockCheckerService stockCheckerService, LoginService loginService, AddressService addressService){
        this.filmService=filmService;
        this.customerService =customerService;
        this.stockCheckerService = stockCheckerService;
        this.loginService = loginService;
        this.addressService = addressService;
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
    public String addCustomer(@RequestParam(name = "username") String username,
                              @RequestParam(name = "password") String password,
                              @RequestParam(name = "firstName") String firstName,
                              @RequestParam(name = "lastName") String lastName,
                              @RequestParam(name = "email") String email,
                              @RequestParam(name = "address") String address,
                              @RequestParam(name = "storeId") Integer storeId){


        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName(firstName);
        customerEntity.setLastName(lastName);
        customerEntity.setEmail(email);
        customerEntity.setStoreId(storeId);
        customerEntity.setActive((byte)1);
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        customerEntity.setCreateDate(ts);
        customerEntity.setAddressId(1);
        customerService.save(customerEntity);

        LoginEntity loginEntity = new LoginEntity();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        loginEntity.setUserName(username);
        loginEntity.setUserPassword(encoder.encode(password));
        loginEntity.setUserRole("USER");
        loginEntity.setUserActivated(1);
        loginEntity.setCustomer_id(customerEntity.getCustomerId());
        loginService.addUser(loginEntity);



        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddress(address);
        addressEntity.setCityId(1);
        addressService.save(addressEntity);
        return "redirect:/employee";
        //when you try your best but you don't succeeeeeeed

    }

    @GetMapping("/addUser")
    public String getAddCustomerPage() {
        return "addUser";
    }

    @PostMapping("/employeeSearch")
    public String employeeSearch (@RequestParam(name = "search") String search, Model model) {
        List<FilmEntity> filmEntityList = filmService.findFilmsByTitle(search);
        List<Boolean> inStock =stockCheckerService.isInStock(filmEntityList);
        model.addAttribute("dueBack", filmService.whenInStock(filmEntityList,inStock));
        model.addAttribute("inStock",inStock);
        model.addAttribute("films", filmEntityList);

        return "employeeResults";
    }
}
