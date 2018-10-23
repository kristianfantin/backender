package com.glovoapp.backender;

import com.glovoapp.backender.controller.OrdersController;
import com.glovoapp.backender.domain.viewer.OrderVM;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class OrdersControllerTest {

    @Autowired
    private OrdersController controller;

    @Test
    void shouldFindOrders() {
        List<OrderVM> orders = controller.orders();
        assertFalse(orders.isEmpty());
    }

    @Test
    void shouldFindAllOrdersForThatCourier() {
        List<OrderVM> orders = controller.orders();
        List<OrderVM> orderVMList = controller.ordersByCourierId("courier-1");

        assertEquals(orders.size(), orderVMList.size());
    }

    @Test
    void shouldFindLessOrdersForThatCourier() {
        List<OrderVM> orders = controller.orders();
        List<OrderVM> orderVMList = controller.ordersByCourierId("courier-3");

        assertTrue(orders.size() > orderVMList.size());

        Double distance = Double.valueOf(0);
        for (OrderVM orderVM : orderVMList) {
            assertTrue(orderVM.getDistance() >= distance);
            distance = orderVM.getDistance();
        }

    }

}
