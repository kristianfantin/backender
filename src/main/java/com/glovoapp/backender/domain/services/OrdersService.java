package com.glovoapp.backender.domain.services;

import com.glovoapp.backender.domain.Courier;
import com.glovoapp.backender.domain.Order;
import com.glovoapp.backender.domain.rule.HideRuleDescription;
import com.glovoapp.backender.domain.rule.HideRuleFurther;
import com.glovoapp.backender.domain.viewer.ViewOrder;
import com.glovoapp.backender.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.glovoapp.backender.domain.calculator.DistanceCalculator.calculateDistance;

@Service
public class OrdersService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private HideRuleDescription hideRuleDescription;

    @Autowired
    private HideRuleFurther hideRuleFurther;

    @Autowired
    private SortService sortService;

    public List<ViewOrder> getViewOrdersOrderBy(Courier courier) {
        List<ViewOrder> newOrderList = getViewOrders(courier);
        return getSortByDistance(newOrderList);
    }

    private List<ViewOrder> getViewOrders(Courier courier) {
        return getOrders(courier)
                .stream()
                .map(order -> getViewOrder(courier, order))
                .collect(Collectors.toList());
    }

    private List<ViewOrder> getSortByDistance(List<ViewOrder> newOrderList) {
        return sortService.getSortByDistance(newOrderList);
    }

    private ViewOrder getViewOrder(Courier courier, Order order) {
        ViewOrder viewOrder = new ViewOrder();
        viewOrder.setCourier(courier);
        viewOrder.setOrder(order);
        viewOrder.setFood(order.getFood());
        viewOrder.setVip(order.getVip());
        viewOrder.setDistance(calculateDistance(courier.getLocation(), order.getDelivery()));
        return viewOrder;
    }

    private List<Order> getOrders(Courier courier) {
        return orderRepository.findAll()
                .stream()
                .filter(order1 -> hideRuleDescription.validate(order1, courier) && hideRuleFurther.validate(order1, courier))
                .collect(Collectors.toList());
    }

}
