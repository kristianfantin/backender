package com.glovoapp.backender;

import com.glovoapp.backender.domain.viewer.OrderVM;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class OrdersControllerTest extends OrdersControllerAssert {

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
        assertsByDistance(orderVMList);
    }

    @Test
    void shouldOrderByVip() {
        ReflectionTestUtils.setField(controller, "orderBy", "VIP", String.class);

        List<OrderVM> orders = controller.orders();
        List<OrderVM> orderVMList = controller.ordersByCourierId("courier-3");

        assertTrue(orders.size() > orderVMList.size());

        OrderVM orderVMOne = orderVMList.get(0);
        OrderVM orderVMTwo = orderVMList.get(1);
        OrderVM orderVMThree = orderVMList.get(2);

        assertTrue(orderVMOne.getVip());
        assertFalse(orderVMTwo.getVip());
        assertFalse(orderVMThree.getVip());

        assertTrue(orderVMOne.getDistance() > orderVMTwo.getDistance());
        assertTrue(orderVMTwo.getDistance() < orderVMThree.getDistance());
    }

}
