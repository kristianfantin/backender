package com.glovoapp.backender.domain.maker;

import com.glovoapp.backender.domain.Courier;
import com.glovoapp.backender.domain.Order;
import com.glovoapp.backender.domain.viewer.ViewOrder;

import static com.glovoapp.backender.domain.calculator.DistanceCalculator.calculateDistance;

public class ViewOrderMaker {

    public static ViewOrder toViewOrder(Courier courier, Order order) {
        ViewOrder viewOrder = new ViewOrder();
        viewOrder.setCourier(courier);
        viewOrder.setOrder(order);
        viewOrder.setFood(order.getFood());
        viewOrder.setVip(order.getVip());
        viewOrder.setDistance(calculateDistance(courier.getLocation(), order.getDelivery()));
        return viewOrder;
    }

}
