package com.glovoapp.backender;

import com.glovoapp.backender.domain.Courier;
import com.glovoapp.backender.domain.Order;
import com.glovoapp.backender.domain.rule.HideRuleFurther;
import com.glovoapp.backender.repositories.CourierRepository;
import com.glovoapp.backender.repositories.OrderRepository;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class HideRuleFurtherTest {

    @Test
    void validateCourier1AndOrder1() {
        Courier courier = new CourierRepository().findById("courier-1");
        Order order = new OrderRepository().findById("order-1");

        assertTrue(new HideRuleFurther().validate(order, courier));
    }

    @Test
    void validateCourier1AndOrder2() {
        Courier courier = new CourierRepository().findById("courier-1");
        Order order = new OrderRepository().findById("order-2");

        assertTrue(new HideRuleFurther().validate(order, courier));
    }

    @Test
    void validateCourier1AndOrder3() {
        Courier courier = new CourierRepository().findById("courier-1");
        Order order = new OrderRepository().findById("order-3");

        assertTrue(new HideRuleFurther().validate(order, courier));
    }

    @Test
    void validateCourier2AndOrder1() {
        Courier courier = new CourierRepository().findById("courier-2");
        Order order = new OrderRepository().findById("order-1");

        assertTrue(new HideRuleFurther().validate(order, courier));
    }

    @Test
    void validateCourier2AndOrder2() {
        Courier courier = new CourierRepository().findById("courier-2");
        Order order = new OrderRepository().findById("order-2");

        assertTrue(new HideRuleFurther().validate(order, courier));
    }

    @Test
    void validateCourier2AndOrder3() {
        Courier courier = new CourierRepository().findById("courier-2");
        Order order = new OrderRepository().findById("order-3");

        assertTrue(new HideRuleFurther().validate(order, courier));
    }

    @Test
    void validateCourier3AndOrder1() {
        Courier courier = new CourierRepository().findById("courier-3");
        Order order = new OrderRepository().findById("order-1");

        assertTrue(new HideRuleFurther().validate(order, courier));
    }

    @Test
    void validateCourier3AndOrder2() {
        Courier courier = new CourierRepository().findById("courier-3");
        Order order = new OrderRepository().findById("order-2");

        assertTrue(new HideRuleFurther().validate(order, courier));
    }

    @Test
    void doNotValidateCourier3AndOrder3() {
        Courier courier = new CourierRepository().findById("courier-3");
        Order order = new OrderRepository().findById("order-3");

        assertFalse(new HideRuleFurther().validate(order, courier));
    }

}
