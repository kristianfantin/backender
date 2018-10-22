package com.glovoapp.backender;


import com.glovoapp.backender.domain.Location;
import com.glovoapp.backender.domain.Order;
import com.glovoapp.backender.repositories.OrderRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {
    @Test
    void findAll() {
        List<Order> orders = new OrderRepository().findAll();

        assertFalse(orders.isEmpty());

        Order firstOrder = orders.get(0);

        Order expected = new Order().withId("order-1")
                .withDescription("I want a pizza cut into very small slices")
                .withFood(true)
                .withVip(false)
                .withPickup(new Location(41.3965463, 2.1963997))
                .withDelivery(new Location(41.407834, 2.1675979));

        assertEquals(expected, firstOrder);
    }

    @Test
    void findById() {
        Order order = new OrderRepository().findById("order-1");
        assertNotNull(order);

        Order expected = new Order().withId("order-1")
                .withDescription("I want a pizza cut into very small slices")
                .withFood(true)
                .withVip(false)
                .withPickup(new Location(41.3965463, 2.1963997))
                .withDelivery(new Location(41.407834, 2.1675979));

        assertEquals(expected, order);
    }
}