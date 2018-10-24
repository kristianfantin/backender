package com.glovoapp.backender;

import com.glovoapp.backender.domain.viewer.SlotVM;
import com.glovoapp.backender.domain.viewer.ViewOrder;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class SlotVMAssertVip {

    private SlotVMAssertVip() {}

    static void assertsBeforeOrderByVip(SlotVM slot) {
        ViewOrder viewOrderOne = slot.getViewOrders().get(0);
        ViewOrder viewOrderTwo = slot.getViewOrders().get(1);
        ViewOrder viewOrderThree = slot.getViewOrders().get(2);
        ViewOrder viewOrderFour = slot.getViewOrders().get(3);

        assertTrue(viewOrderOne.getVip());
        assertFalse(viewOrderTwo.getVip());
        assertFalse(viewOrderThree.getVip());
        assertTrue(viewOrderFour.getVip());
    }

    static void assertsAfterOrderByVip(SlotVM slot) {
        ViewOrder viewOrderOne = slot.getViewOrders().get(0);
        ViewOrder viewOrderTwo = slot.getViewOrders().get(1);
        ViewOrder viewOrderThree = slot.getViewOrders().get(2);
        ViewOrder viewOrderFour = slot.getViewOrders().get(3);

        assertTrue(viewOrderOne.getVip());
        assertTrue(viewOrderTwo.getVip());
        assertFalse(viewOrderThree.getVip());
        assertFalse(viewOrderFour.getVip());
    }

}
