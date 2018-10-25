package com.glovoapp.backender;

import com.glovoapp.backender.controller.OrdersController;
import com.glovoapp.backender.domain.viewer.OrderVM;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertTrue;

class OrdersControllerAssert {

    @Autowired
    OrdersController controller;

    void assertsByDistance(List<OrderVM> orderVMList) {
        Double distance = Double.valueOf(0);
        for (OrderVM orderVM : orderVMList) {
            assertTrue(orderVM.getDistance() >= distance);
            distance = orderVM.getDistance();
        }
    }

}
