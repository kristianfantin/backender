package com.glovoapp.backender.domain.maker;

import com.glovoapp.backender.domain.Order;
import com.glovoapp.backender.domain.viewer.OrderVM;
import com.glovoapp.backender.domain.viewer.ViewOrder;

import static com.glovoapp.backender.domain.calculator.DistanceCalculator.calculateDistance;

public class OrderMaker {

    public static OrderVM toOrderVM(ViewOrder viewOrder) {
        return new OrderVM(viewOrder.getOrder().getId(), viewOrder.getOrder().getDescription(), viewOrder.getDistance(), viewOrder.getVip(), viewOrder.getFood());
    }

    public static OrderVM toOrderVM(Order order) {
        return new OrderVM(order.getId(), order.getDescription(), calculateDistance(order.getPickup(), order.getDelivery()), order.getVip(), order.getFood());
    }
}
