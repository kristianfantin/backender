package com.glovoapp.backender.domain.rule;

import com.glovoapp.backender.domain.Courier;
import com.glovoapp.backender.domain.Order;
import com.glovoapp.backender.domain.calculator.DistanceCalculator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.glovoapp.backender.domain.type.Vehicle.ELECTRIC_SCOOTER;
import static com.glovoapp.backender.domain.type.Vehicle.MOTORCYCLE;

@Component
public class HideRuleFurther {

    private static final boolean PATTERN_RESULT = false;

    @Value("${backender.hide_further_than_in_km}")
    private Double furtherThan;

    public boolean validate(Order order, Courier courier) {
        return  (isInputNull(order, courier))? PATTERN_RESULT : getRule(order, courier);
    }

    private boolean getRule(Order order, Courier courier) {
        Double distance = DistanceCalculator.calculateDistance(courier.getLocation(), order.getDelivery());
        return !(distance > furtherThan && !isMotorcycleOrEletricScooter(courier));
    }

    private boolean isInputNull(Order order, Courier courier) {
        return order == null || courier == null;
    }

    private boolean isMotorcycleOrEletricScooter(Courier courier) {
        return courier.getVehicle().equals(MOTORCYCLE) || courier.getVehicle().equals(ELECTRIC_SCOOTER);
    }
}
