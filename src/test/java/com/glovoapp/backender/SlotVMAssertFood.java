package com.glovoapp.backender;

import com.glovoapp.backender.domain.viewer.SlotVM;
import com.glovoapp.backender.domain.viewer.ViewOrder;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class SlotVMAssertFood {

    private SlotVMAssertFood() {}

    static void assertsBeforeOrderByFood(SlotVM slot) {
        ViewOrder viewOrderOne = slot.getViewOrders().get(0);
        ViewOrder viewOrderTwo = slot.getViewOrders().get(1);
        ViewOrder viewOrderThree = slot.getViewOrders().get(2);
        ViewOrder viewOrderFour = slot.getViewOrders().get(3);

        assertFalse(viewOrderOne.getFood());
        assertTrue(viewOrderTwo.getFood());
        assertTrue(viewOrderThree.getFood());
        assertTrue(viewOrderFour.getFood());
    }

    static void assertsAfterOrderByFood(SlotVM slot) {
        ViewOrder viewOrderOne = slot.getViewOrders().get(0);
        ViewOrder viewOrderTwo = slot.getViewOrders().get(1);
        ViewOrder viewOrderThree = slot.getViewOrders().get(2);
        ViewOrder viewOrderFour = slot.getViewOrders().get(3);

        assertTrue(viewOrderOne.getFood());
        assertTrue(viewOrderTwo.getFood());
        assertTrue(viewOrderThree.getFood());
        assertFalse(viewOrderFour.getFood());
    }


}
