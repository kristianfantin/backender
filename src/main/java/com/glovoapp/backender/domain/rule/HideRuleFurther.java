package com.glovoapp.backender.domain.rule;

import com.glovoapp.backender.domain.Courier;
import com.glovoapp.backender.domain.Order;
import com.glovoapp.backender.domain.calculator.DistanceCalculator;
import org.springframework.stereotype.Component;

import static com.glovoapp.backender.domain.type.Vehicle.ELECTRIC_SCOOTER;
import static com.glovoapp.backender.domain.type.Vehicle.MOTORCYCLE;

@Component
public class HideRuleFurther {

    private static final Double FURTHER_THAN = 5.00;

    public boolean validate(Order order, Courier courier) {
        Double distance = DistanceCalculator.calculateDistance(courier.getLocation(), order.getDelivery());
        return !(distance > FURTHER_THAN && !isMotorcycleOrEletricScooter(courier));
    }

    private boolean isMotorcycleOrEletricScooter(Courier courier) {
        return courier.getVehicle().equals(MOTORCYCLE) || courier.getVehicle().equals(ELECTRIC_SCOOTER);
    }
}
