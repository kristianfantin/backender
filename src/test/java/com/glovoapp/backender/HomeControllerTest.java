package com.glovoapp.backender;

import com.glovoapp.backender.controller.HomeController;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class HomeControllerTest {

    @Test
    void happyDay() {
        HomeController homeController = new HomeController();
        assertEquals("redirect:swagger-ui.html", homeController.home());
    }

}
