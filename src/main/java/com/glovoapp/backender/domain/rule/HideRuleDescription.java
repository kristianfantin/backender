package com.glovoapp.backender.domain.rule;

import com.glovoapp.backender.domain.Courier;
import com.glovoapp.backender.domain.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class HideRuleDescription {

    private static final List<String> LIST_OF_EXCEPTIONS = Arrays.asList("pizza","cake","flamingo");
    private static final boolean PATTERN_RESULT = false;

    public boolean validate(Order order, Courier courier) {
        return (isInputNull(order, courier)) ?
                PATTERN_RESULT :
                LIST_OF_EXCEPTIONS
                        .stream()
                        .noneMatch(description -> isDescriptionRule(order, description) && !isEquippedWithGlovoBox(courier));
    }

    private boolean isInputNull(Order order, Courier courier) {
        return order == null || courier == null;
    }

    private Boolean isEquippedWithGlovoBox(Courier courier) {
        return courier.getBox();
    }

    private boolean isDescriptionRule(Order order, String description) {
        return order.getDescription().toUpperCase().contains(description.toUpperCase());
    }
}
