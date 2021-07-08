package com.sparta.eng87.spartaglobal_vhswebsite.services;


import com.sparta.eng87.spartaglobal_vhswebsite.entities.CustomerEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.repositories.CustomerRepository;
import com.sparta.eng87.spartaglobal_vhswebsite.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private LoginRepository loginRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, LoginRepository loginRepository) {
        this.customerRepository = customerRepository;
        this.loginRepository=loginRepository;
    }

    public void save(CustomerEntity customerEntity){
        customerRepository.save(customerEntity);
    }

    public Integer findCustomerIdByUsername(String username) {
        return loginRepository.findCustomerIdByUsername(username);
    }

    public List<Object[]> getCurrentlyRentedFilmsByCustomerId(Integer id){

       List<Object[]> temp = customerRepository.getCurrentlyRentedFilmsByCustomerId(id);

       for(Object[] film : temp){
           Timestamp ts = (Timestamp) film[2];
           ts.setTime(ts.getTime() + 604800000);
           film[2] = ts.toString().substring(0,11);
       }

       return temp;
    }

    public List<Object[]> getPreviouslyRentedFilmsByCustomerId(Integer id){

        List<Object[]> temp = customerRepository.getPreviouslyRentedFilmsByCustomerId(id);
        for(Object[] film : temp){
            Timestamp ts = (Timestamp) film[2];
            film[2] = ts.toString().substring(0,11);
        }
      return temp;
    }
}
