package com.sparta.eng87.spartaglobal_vhswebsite.services;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.LoginEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public void addUser(LoginEntity loginEntity){
        loginRepository.save(loginEntity);
    }
}
