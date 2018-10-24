package com.glovoapp.backender;

import com.glovoapp.backender.domain.services.OrderBy;
import org.junit.jupiter.api.Test;

import static com.glovoapp.backender.domain.services.OrderBy.FOOD_VIP;
import static com.glovoapp.backender.domain.services.OrderBy.VIP_FOOD;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

class OrderByTest {

    @Test
    void shouldReturnVipAndFood() {
        assertEquals(VIP_FOOD, OrderBy.getValue("VIP_FOOD"));
    }

    @Test
    void shouldReturnFoodAndVip() {
        assertEquals(FOOD_VIP, OrderBy.getValue("FOOD_VIP"));
    }

    @Test
    void shouldBeNull() {
        assertNull(OrderBy.getValue(""));
    }
}
