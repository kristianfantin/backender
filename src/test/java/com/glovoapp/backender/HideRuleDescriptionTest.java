package com.glovoapp.backender;

import com.glovoapp.backender.domain.Courier;
import com.glovoapp.backender.domain.Order;
import com.glovoapp.backender.domain.rule.HideRuleDescription;
import com.glovoapp.backender.repositories.CourierRepository;
import com.glovoapp.backender.repositories.OrderRepository;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class HideRuleDescriptionTest {

    @Test
    void shouldValidateOrderAndCourier() {
        Courier courier = new CourierRepository().findById("courier-1");
        Order order = new OrderRepository().findById("order-1");

        assertTrue(new HideRuleDescription().validate(order, courier));
    }

    @Test
    void shouldNotValidateOrderAndCourier() {
        Courier courier = new CourierRepository().findById("courier-2");
        Order order = new OrderRepository().findById("order-1");

        assertFalse(new HideRuleDescription().validate(order, courier));
    }

    @Test
    void shouldValidateOrderAndCourierWithNoDescriptionInRule() {
        Courier courier = new CourierRepository().findById("courier-1");
        Order order = new OrderRepository().findById("order-2");

        assertTrue(new HideRuleDescription().validate(order, courier));
    }

    @Test
    void shouldValidateOrderAndCourierWithNoDescriptionInRuleAdnNoGlovoBox() {
        Courier courier = new CourierRepository().findById("courier-2");
        Order order = new OrderRepository().findById("order-2");

        assertTrue(new HideRuleDescription().validate(order, courier));
    }

    @Test
    void invalidCourier() {
        Courier courier = new CourierRepository().findById("courier-999");
        Order order = new OrderRepository().findById("order-3");

        assertFalse(new HideRuleDescription().validate(order, courier));
    }

    @Test
    void invalidOrder() {
        Courier courier = new CourierRepository().findById("courier-1");
        Order order = new OrderRepository().findById("order-999");

        assertFalse(new HideRuleDescription().validate(order, courier));
    }

}
