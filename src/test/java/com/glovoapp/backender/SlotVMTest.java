package com.glovoapp.backender;

import com.glovoapp.backender.domain.services.OrdersService;
import com.glovoapp.backender.domain.services.SlotService;
import com.glovoapp.backender.domain.viewer.SlotVM;
import com.glovoapp.backender.domain.viewer.ViewOrder;
import com.glovoapp.backender.repositories.CourierRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class SlotVMTest {

    @Autowired
    private SlotService slotService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private CourierRepository courierRepository;

    @Test
    void initSlots() {
        List<SlotVM> list = slotService.getSlotVM();
        assertTrue(list.size() > 1);
    }

    @Test
    void shouldDivideInSlots() {
        List<ViewOrder> viewOrderList = ordersService.getViewOrdersOrderBy(courierRepository.findById("courier-1"));
        List<SlotVM> list = slotService.getSlots(viewOrderList);
        assertTrue(list.size() > 1);

        SlotVM slotOne = list.get(0);
        assertEquals(4, slotOne.getViewOrders().size());
        SlotVM slotTwo = list.get(1);
        assertEquals(3, slotTwo.getViewOrders().size());
        SlotVM slotThree = list.get(2);
        assertEquals(0, slotThree.getViewOrders().size());
    }

    @Test
    void shouldOrderByVip() {
        List<ViewOrder> viewOrderList = ordersService.getViewOrdersOrderBy(courierRepository.findById("courier-1"));
        List<SlotVM> list = slotService.getSlots(viewOrderList);

    }
}
