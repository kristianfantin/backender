package com.glovoapp.backender;

import com.glovoapp.backender.domain.services.SlotService;
import com.glovoapp.backender.domain.viewer.OrderVM;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class OrdersControllerMockTest extends OrdersControllerAssert {

    @Autowired
    @MockBean
    private SlotService slotService;

    @Test
    void shouldFindAllOrdersForThatCourierWithoutSlots() {
        when(slotService.getSlots(any())).thenReturn(new ArrayList<>());

        List<OrderVM> orders = controller.orders();
        List<OrderVM> orderVMList = controller.ordersByCourierId("courier-1");

        assertEquals(orders.size(), orderVMList.size());
        assertsByDistance(orderVMList);
    }

}
