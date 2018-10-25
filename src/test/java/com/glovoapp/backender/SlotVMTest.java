package com.glovoapp.backender;

import com.glovoapp.backender.domain.services.OrdersService;
import com.glovoapp.backender.domain.services.SlotService;
import com.glovoapp.backender.domain.services.sort.OrderBy;
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
        List<ViewOrder> viewOrderList = ordersService.getViewOrdersOrderByDistance(courierRepository.findById("courier-1"));
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
        List<ViewOrder> viewOrderList = ordersService.getViewOrdersOrderByDistance(courierRepository.findById("courier-1"));
        List<SlotVM> list = slotService.getSlots(viewOrderList);

        SlotVM slotOne = list.get(0);
        assertEquals(4, slotOne.getViewOrders().size());
        SlotVMAssertVip.assertsBeforeOrderByVip(slotOne);

        List<SlotVM> listOrderByVip = OrderBy.VIP.getSlots(list);
        slotOne = listOrderByVip.get(0);
        assertEquals(4, slotOne.getViewOrders().size());
        SlotVMAssertVip.assertsAfterOrderByVip(slotOne);
    }

    @Test
    void shouldOrderByFood() {
        List<ViewOrder> viewOrderList = ordersService.getViewOrdersOrderByDistance(courierRepository.findById("courier-1"));
        List<SlotVM> list = slotService.getSlots(viewOrderList);

        SlotVM slotOne = list.get(0);
        assertEquals(4, slotOne.getViewOrders().size());
        SlotVMAssertFood.assertsBeforeOrderByFood(slotOne);

        List<SlotVM> listOrderByVip = OrderBy.FOOD.getSlots(list);
        slotOne = listOrderByVip.get(0);
        assertEquals(4, slotOne.getViewOrders().size());
        SlotVMAssertFood.assertsAfterOrderByFood(slotOne);
    }

    @Test
    void shouldOrderByVipAndFood() {
        List<ViewOrder> viewOrderList = ordersService.getViewOrdersOrderByDistance(courierRepository.findById("courier-1"));
        List<SlotVM> list = slotService.getSlots(viewOrderList);

        SlotVM slotOne = list.get(0);
        assertEquals(4, slotOne.getViewOrders().size());
        SlotVMAssertVipAndFood.assertsBeforeOrderByVipAndFood(slotOne);

        List<SlotVM> listOrderByVip = OrderBy.VIP_FOOD.getSlots(list);
        slotOne = listOrderByVip.get(0);
        assertEquals(4, slotOne.getViewOrders().size());
        SlotVMAssertVipAndFood.assertsAfterOrderByVipAndFood(slotOne);
    }

    @Test
    void shouldOrderByFoodAndVip() {
        List<ViewOrder> viewOrderList = ordersService.getViewOrdersOrderByDistance(courierRepository.findById("courier-1"));
        List<SlotVM> list = slotService.getSlots(viewOrderList);

        SlotVM slotOne = list.get(0);
        assertEquals(4, slotOne.getViewOrders().size());
        SlotVMAssertFoodAndVip.assertsBeforeOrderByFoodAndVip(slotOne);

        List<SlotVM> listOrderByVip = OrderBy.FOOD_VIP.getSlots(list);
        slotOne = listOrderByVip.get(0);
        assertEquals(4, slotOne.getViewOrders().size());
        SlotVMAssertFoodAndVip.assertsAfterOrderByFoodAndVip(slotOne);
    }

}
