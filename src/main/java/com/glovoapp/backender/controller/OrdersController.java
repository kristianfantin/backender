package com.glovoapp.backender.controller;

import com.glovoapp.backender.domain.Courier;
import com.glovoapp.backender.domain.Order;
import com.glovoapp.backender.domain.OrderVM;
import com.glovoapp.backender.domain.rule.HideRuleDescription;
import com.glovoapp.backender.domain.rule.HideRuleFurther;
import com.glovoapp.backender.repositories.CourierRepository;
import com.glovoapp.backender.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrdersController {

    private final OrderRepository orderRepository;
    private final CourierRepository courierRepository;
    private final HideRuleDescription hideRuleDescription;
    private final HideRuleFurther hideRuleFurther;

    @Autowired
    public OrdersController(OrderRepository orderRepository, CourierRepository courierRepository,
                            HideRuleDescription hideRuleDescription, HideRuleFurther hideRuleFurther) {
        this.orderRepository = orderRepository;
        this.courierRepository = courierRepository;
        this.hideRuleDescription = hideRuleDescription;
        this.hideRuleFurther = hideRuleFurther;
    }

    @GetMapping("/orders")
    @ResponseBody
    public List<OrderVM> orders() {
        return orderRepository.findAll()
                .stream()
                .map(order -> new OrderVM(order.getId(), order.getDescription()))
                .collect(Collectors.toList());
    }

    @GetMapping("/orders/{courierId}")
    @ResponseBody
    public List<OrderVM> ordersByCourierId(@RequestParam String courierId) {
        return getOrders(courierRepository.findById(courierId))
                .stream()
                .map(order -> new OrderVM(order.getId(), order.getDescription()))
                .collect(Collectors.toList());
    }

    private List<Order> getOrders(Courier courier) {
        return orderRepository.findAll()
                .stream()
                .filter(order1 -> hideRuleDescription.validate(order1, courier) && hideRuleFurther.validate(order1, courier))
                .collect(Collectors.toList());
    }

}
