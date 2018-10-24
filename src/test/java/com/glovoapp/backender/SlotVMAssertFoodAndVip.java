package com.glovoapp.backender;

import com.glovoapp.backender.domain.viewer.SlotVM;
import com.glovoapp.backender.domain.viewer.ViewOrder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SlotVMAssertFoodAndVip {

    private SlotVMAssertFoodAndVip() {}

    static void assertsBeforeOrderByFoodAndVip(SlotVM slot) {
        ViewOrder viewOrderOne = slot.getViewOrders().get(0);
        ViewOrder viewOrderTwo = slot.getViewOrders().get(1);
        ViewOrder viewOrderThree = slot.getViewOrders().get(2);
        ViewOrder viewOrderFour = slot.getViewOrders().get(3);

        assertFalse(viewOrderOne.getFood());
        assertTrue(viewOrderOne.getVip());

        assertTrue(viewOrderTwo.getFood());
        assertFalse(viewOrderTwo.getVip());

        assertTrue(viewOrderThree.getFood());
        assertFalse(viewOrderThree.getVip());

        assertTrue(viewOrderFour.getFood());
        assertTrue(viewOrderFour.getVip());
    }

    static void assertsAfterOrderByFoodAndVip(SlotVM slot) {
        ViewOrder viewOrderOne = slot.getViewOrders().get(0);
        ViewOrder viewOrderTwo = slot.getViewOrders().get(1);
        ViewOrder viewOrderThree = slot.getViewOrders().get(2);
        ViewOrder viewOrderFour = slot.getViewOrders().get(3);

        assertTrue(viewOrderOne.getFood());
        assertTrue(viewOrderOne.getVip());

        assertTrue(viewOrderTwo.getFood());
        assertFalse(viewOrderTwo.getVip());

        assertTrue(viewOrderThree.getFood());
        assertFalse(viewOrderThree.getVip());

        assertFalse(viewOrderFour.getFood());
        assertTrue(viewOrderFour.getVip());
    }
}
