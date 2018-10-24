package com.glovoapp.backender.controller;

import com.glovoapp.backender.domain.maker.CourierMaker;
import com.glovoapp.backender.domain.maker.OrderMaker;
import com.glovoapp.backender.domain.services.OrdersService;
import com.glovoapp.backender.domain.viewer.CourierVM;
import com.glovoapp.backender.domain.viewer.OrderVM;
import com.glovoapp.backender.repositories.CourierRepository;
import com.glovoapp.backender.repositories.OrderRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = { "ordersController" })
@RestController
public class OrdersController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CourierRepository courierRepository;

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/orders")
    @ResponseBody
    public List<OrderVM> orders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderMaker::toOrderVM)
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

    @ApiOperation(value = "Orders find by Id of Courier")
    @GetMapping("/orders/{courierId}")
    @ResponseBody
    public List<OrderVM> ordersByCourierId(@RequestParam String courierId) {
        return ordersService.getViewOrdersOrderBy(courierRepository.findById(courierId))
                .stream()
                .map(OrderMaker::toOrderVM)
                .collect(Collectors.toList());
    }


}
