package com.glovoapp.backender;

import com.glovoapp.backender.controller.CouriersController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertFalse;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CouriersControllerTest {

    @Autowired
    private CouriersController controller;

    @Test
    void shouldFindCouriers() {
        assertFalse(controller.couriers().isEmpty());
    }

}
