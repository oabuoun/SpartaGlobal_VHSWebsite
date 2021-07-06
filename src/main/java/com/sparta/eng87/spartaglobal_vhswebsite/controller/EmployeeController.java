package com.sparta.eng87.spartaglobal_vhswebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    // TODO


    private VHSService vhsService;
    private CustomerService customerService;

    @Autowired
    public EmployeeController(VHSService vhsService, CustomerService customerService){
        this.vhsService=vhsService;
        this.customerService =customerService;
    }

    @PostMapping("/addVHS")
    public void addVHS(){
        VHSEntity vhsEntity = new VHSEntity;
        vhsService.save(vhsEntity);
    }

    @PostMapping("/addcustomer")
    public void addCustomer(){
        CustomerEntity customerEntity = new CustomerEntity;
        customerService.save(customerEntity);
    }




}
