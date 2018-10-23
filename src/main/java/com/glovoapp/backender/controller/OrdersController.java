package com.glovoapp.backender.controller;

import com.glovoapp.backender.domain.maker.CourierMaker;
import com.glovoapp.backender.domain.services.SlotService;
import com.glovoapp.backender.domain.viewer.CourierVM;
import com.glovoapp.backender.domain.viewer.OrderVM;
import com.glovoapp.backender.repositories.CourierRepository;
import com.glovoapp.backender.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.glovoapp.backender.domain.calculator.DistanceCalculator.calculateDistance;

@RestController
public class OrdersController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CourierRepository courierRepository;

    @Autowired
    private SlotService slotService;

    @GetMapping("/orders")
    @ResponseBody
    public List<OrderVM> orders() {
        return orderRepository.findAll()
                .stream()
                .map(order -> new OrderVM(order.getId(), order.getDescription(), calculateDistance(order.getPickup(), order.getDelivery())))
                .collect(Collectors.toList());
    }

    @GetMapping("/couriers")
    @ResponseBody
    public List<CourierVM> couriers() {
        return courierRepository.findAll()
                .stream()
                .map(CourierMaker::toCourierVM)
                .collect(Collectors.toList());
    }

    @GetMapping("/orders/{courierId}")
    @ResponseBody
    public List<OrderVM> ordersByCourierId(@RequestParam String courierId) {
        return slotService.getViewOrdersOrderBy(courierRepository.findById(courierId))
                .stream()
                .map(order -> new OrderVM(order.getOrder().getId(), order.getOrder().getDescription(), order.getDistance()))
                .collect(Collectors.toList());
    }


}
