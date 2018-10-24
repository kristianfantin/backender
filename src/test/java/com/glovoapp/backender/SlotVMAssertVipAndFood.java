package com.glovoapp.backender;

import com.glovoapp.backender.domain.viewer.SlotVM;
import com.glovoapp.backender.domain.viewer.ViewOrder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SlotVMAssertVipAndFood {

    private SlotVMAssertVipAndFood() {}

    static void assertsBeforeOrderByVipAndFood(SlotVM slot) {
        ViewOrder viewOrderOne = slot.getViewOrders().get(0);
        ViewOrder viewOrderTwo = slot.getViewOrders().get(1);
        ViewOrder viewOrderThree = slot.getViewOrders().get(2);
        ViewOrder viewOrderFour = slot.getViewOrders().get(3);

        assertTrue(viewOrderOne.getVip());
        assertFalse(viewOrderOne.getFood());

        assertFalse(viewOrderTwo.getVip());
        assertTrue(viewOrderTwo.getFood());

        assertFalse(viewOrderThree.getVip());
        assertTrue(viewOrderThree.getFood());

        assertTrue(viewOrderFour.getVip());
        assertTrue(viewOrderFour.getFood());
    }

    static void assertsAfterOrderByVipAndFood(SlotVM slot) {
        ViewOrder viewOrderOne = slot.getViewOrders().get(0);
        ViewOrder viewOrderTwo = slot.getViewOrders().get(1);
        ViewOrder viewOrderThree = slot.getViewOrders().get(2);
        ViewOrder viewOrderFour = slot.getViewOrders().get(3);

        assertTrue(viewOrderOne.getVip());
        assertTrue(viewOrderOne.getFood());

        assertTrue(viewOrderTwo.getVip());
        assertFalse(viewOrderTwo.getFood());

        assertFalse(viewOrderThree.getVip());
        assertTrue(viewOrderThree.getFood());

        assertFalse(viewOrderFour.getVip());
        assertTrue(viewOrderFour.getFood());
    }
}
