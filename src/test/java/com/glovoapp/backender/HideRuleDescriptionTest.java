package com.glovoapp.backender;

import com.glovoapp.backender.domain.Courier;
import com.glovoapp.backender.domain.Order;
import com.glovoapp.backender.domain.rule.HideRuleDescription;
import com.glovoapp.backender.repositories.CourierRepository;
import com.glovoapp.backender.repositories.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class HideRuleDescriptionTest {

    @Autowired
    private HideRuleDescription hideRuleDescription;

    @Test
    void shouldValidateOrderAndCourier() {
        Courier courier = new CourierRepository().findById("courier-1");
        Order order = new OrderRepository().findById("order-1");

        assertTrue(hideRuleDescription.validate(order, courier));
    }

    @Test
    void shouldNotValidateOrderAndCourier() {
        Courier courier = new CourierRepository().findById("courier-2");
        Order order = new OrderRepository().findById("order-1");

        assertFalse(hideRuleDescription.validate(order, courier));
    }

    @Test
    void shouldValidateOrderAndCourierWithNoDescriptionInRule() {
        Courier courier = new CourierRepository().findById("courier-1");
        Order order = new OrderRepository().findById("order-2");

        assertTrue(hideRuleDescription.validate(order, courier));
    }

    @Test
    void shouldValidateOrderAndCourierWithNoDescriptionInRuleAdnNoGlovoBox() {
        Courier courier = new CourierRepository().findById("courier-2");
        Order order = new OrderRepository().findById("order-2");

        assertTrue(hideRuleDescription.validate(order, courier));
    }

    @Test
    void invalidCourier() {
        Courier courier = new CourierRepository().findById("courier-999");
        Order order = new OrderRepository().findById("order-3");

        assertFalse(hideRuleDescription.validate(order, courier));
    }

    @Test
    void invalidOrder() {
        Courier courier = new CourierRepository().findById("courier-1");
        Order order = new OrderRepository().findById("order-999");

        assertFalse(hideRuleDescription.validate(order, courier));
    }

}
