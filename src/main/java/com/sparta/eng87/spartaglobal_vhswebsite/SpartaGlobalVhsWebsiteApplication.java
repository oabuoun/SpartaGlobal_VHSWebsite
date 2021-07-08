package com.sparta.eng87.spartaglobal_vhswebsite;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.LoginEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.services.LoginService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpartaGlobalVhsWebsiteApplication {



    public static void main(String[] args) {
        SpringApplication.run(SpartaGlobalVhsWebsiteApplication.class, args);
    }


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Bean
    public CommandLineRunner demo(LoginService loginService){
        return (args) -> {
            LoginEntity loginEntity = new LoginEntity();
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            loginEntity.setUserName("Harry");
            loginEntity.setUserPassword(encoder.encode("Harry"));
            loginEntity.setUserRole("USER");
            loginEntity.setUserActivated(1);
            //loginService.addUser(loginEntity);
            //loginService.addUser(new LoginEntity("employee", encoder.encode("password"), "EMPLOYEE",1 , 1 ,1 ));
            //loginService.addUser(new LoginEntity("user", encoder.encode("password"), "CUSTOMER",1 , 1 ,1 ));
        };
    }
}
