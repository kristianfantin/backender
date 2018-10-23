package com.glovoapp.backender.domain.services;

import com.glovoapp.backender.domain.Courier;
import com.glovoapp.backender.domain.Order;
import com.glovoapp.backender.domain.rule.HideRuleDescription;
import com.glovoapp.backender.domain.rule.HideRuleFurther;
import com.glovoapp.backender.domain.viewer.SlotVM;
import com.glovoapp.backender.domain.viewer.ViewOrder;
import com.glovoapp.backender.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.glovoapp.backender.domain.calculator.DistanceCalculator.calculateDistance;

@Service
public class SlotService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private HideRuleDescription hideRuleDescription;

    @Autowired
    private HideRuleFurther hideRuleFurther;

    @Value("${backender.slots}")
    private String slots;

    public List<SlotVM> getSlotVM() {

        String[] split = slots.split(";");
        return Arrays
                .stream(split).map(s -> s.split("-"))
                .map(this::getSlotVM)
                .collect(Collectors.toList());
    }

    private SlotVM getSlotVM(String[] distance) {
        SlotVM slotVM = new SlotVM();
        slotVM.setInitDistance(Double.valueOf(distance[0]));
        slotVM.setFinalDistance(Double.valueOf(distance[1]));
        return slotVM;
    }

    public List<ViewOrder> getViewOrdersOrderBy(Courier courier) {
        List<ViewOrder> newOrderList = getViewOrders(courier);
        getSortByDistance(newOrderList);
        return newOrderList;
    }

    private List<ViewOrder> getViewOrders(Courier courier) {
        return getOrders(courier)
                .stream()
                .map(order -> getViewOrder(courier, order))
                .collect(Collectors.toList());
    }

    private void getSortByDistance(List<ViewOrder> newOrderList) {
        newOrderList.sort((ViewOrder order1, ViewOrder order2) -> order1.getDistance().compareTo(order2.getDistance()));
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
