package com.glovoapp.backender.domain.services;

import com.glovoapp.backender.domain.Courier;
import com.glovoapp.backender.domain.Order;
import com.glovoapp.backender.domain.rule.HideRuleDescription;
import com.glovoapp.backender.domain.rule.HideRuleFurther;
import com.glovoapp.backender.domain.services.sort.SortByDistanceService;
import com.glovoapp.backender.domain.viewer.ViewOrder;
import com.glovoapp.backender.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.glovoapp.backender.domain.maker.ViewOrderMaker.toViewOrder;

@Service
public class OrdersService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private HideRuleDescription hideRuleDescription;

    @Autowired
    private HideRuleFurther hideRuleFurther;

    @Autowired
    private SortByDistanceService sortByDistanceService;

    public List<ViewOrder> getViewOrdersOrderBy(Courier courier) {
        List<ViewOrder> newOrderList = getViewOrders(courier);
        return sortByDistanceService.getSort(newOrderList);
    }

    private List<ViewOrder> getViewOrders(Courier courier) {
        return getOrders(courier)
                .stream()
                .map(order -> toViewOrder(courier, order))
                .collect(Collectors.toList());
    }

    private List<Order> getOrders(Courier courier) {
        return orderRepository.findAll()
                .stream()
                .filter(order1 -> hideRuleDescription.validate(order1, courier) && hideRuleFurther.validate(order1, courier))
                .collect(Collectors.toList());
    }

}
