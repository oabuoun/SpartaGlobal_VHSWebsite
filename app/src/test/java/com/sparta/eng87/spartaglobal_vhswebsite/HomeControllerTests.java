package com.sparta.eng87.spartaglobal_vhswebsite;

import com.sparta.eng87.spartaglobal_vhswebsite.controller.HomeController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

@SpringBootTest
class HomeControllerTests {

    @Autowired
    private HomeController homeController;

    @Test
    void contextLoads() {
        Model model = new ConcurrentModel();
        Assertions.assertEquals("index",homeController.getVHSForDisplay(model));
    }

}
