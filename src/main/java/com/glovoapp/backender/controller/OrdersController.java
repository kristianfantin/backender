package com.glovoapp.backender.controller;

import com.glovoapp.backender.domain.maker.OrderMaker;
import com.glovoapp.backender.domain.services.OrdersService;
import com.glovoapp.backender.domain.services.SlotService;
import com.glovoapp.backender.domain.services.sort.OrderBy;
import com.glovoapp.backender.domain.viewer.OrderVM;
import com.glovoapp.backender.domain.viewer.SlotVM;
import com.glovoapp.backender.domain.viewer.ViewOrder;
import com.glovoapp.backender.repositories.CourierRepository;
import com.glovoapp.backender.repositories.OrderRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    private SlotService slotService;

    @Value("${backender.order_by}")
    private String orderBy;

    @GetMapping("/orders")
    @ResponseBody
    public List<OrderVM> orders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderMaker::toOrderVM)
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Orders find by Id of Courier")
    @GetMapping("/orders/{courierId}")
    @ResponseBody
    public List<OrderVM> ordersByCourierId(@RequestParam String courierId) {
        List<ViewOrder> orders = ordersService.getViewOrdersOrderBy(courierRepository.findById(courierId));

        return getSlotsOrdered(orders)
                .stream()
                .flatMap(slotVM -> slotVM.getViewOrders().stream())
                .map(OrderMaker::toOrderVM)
                .collect(Collectors.toList());
    }

    private List<SlotVM> getSlotsOrdered(List<ViewOrder> orders) {
        List<SlotVM> listSlot = slotService.getSlots(orders);
        OrderBy orderByParam = OrderBy.getValue(orderBy);
        if (orderByParam != null)
            listSlot = orderByParam.getSlots(listSlot);

        return listSlot;
    }


}
