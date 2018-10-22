package com.glovoapp.backender.domain.rule;

import com.glovoapp.backender.domain.Courier;
import com.glovoapp.backender.domain.Order;

import java.util.Arrays;
import java.util.List;

public class HideRuleDescription {

    private static final List<String> LIST_OF_EXCEPTIONS = Arrays.asList("pizza","cake","flamingo");

    public boolean validate(Order order, Courier courier) {
        for (String description : LIST_OF_EXCEPTIONS) {
            if (isDescriptionRule(order, description) && !isEquippedWithGlovoBox(courier)) {
                return false;
            }
        }
        return true;
    }

    private Boolean isEquippedWithGlovoBox(Courier courier) {
        return courier.getBox();
    }

    private boolean isDescriptionRule(Order order, String description) {
        return order.getDescription().contains(description);
    }
}
