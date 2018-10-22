package com.glovoapp.backender;

import com.glovoapp.backender.controller.OrdersController;
import com.glovoapp.backender.domain.OrderVM;
import com.glovoapp.backender.domain.rule.HideRuleDescription;
import com.glovoapp.backender.domain.rule.HideRuleFurther;
import com.glovoapp.backender.repositories.CourierRepository;
import com.glovoapp.backender.repositories.OrderRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

class OrdersControllerTest {

    @Test
    void shouldFindOrders() {
        OrdersController controller = new OrdersController(new OrderRepository(), new CourierRepository(), new HideRuleDescription(), new HideRuleFurther());
        List<OrderVM> orders = controller.orders();
        assertFalse(orders.isEmpty());
    }

    @Test
    void shouldFindAllOrdersForThatCourier() {
        OrdersController controller = new OrdersController(new OrderRepository(), new CourierRepository(), new HideRuleDescription(), new HideRuleFurther());

        List<OrderVM> orders = controller.orders();
        List<OrderVM> orderVMList = controller.ordersByCourierId("courier-1");

        assertEquals(orders.size(), orderVMList.size());
    }

    @Test
    void shouldFindLessOrdersForThatCourier() {
        OrdersController controller = new OrdersController(new OrderRepository(), new CourierRepository(), new HideRuleDescription(), new HideRuleFurther());

        List<OrderVM> orders = controller.orders();
        List<OrderVM> orderVMList = controller.ordersByCourierId("courier-3");

        assertTrue(orders.size() > orderVMList.size());
    }

}
