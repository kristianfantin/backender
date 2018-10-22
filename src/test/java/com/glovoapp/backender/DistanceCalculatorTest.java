package com.glovoapp.backender;

import com.glovoapp.backender.domain.Location;
import com.glovoapp.backender.domain.calculator.DistanceCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DistanceCalculatorTest {

    @Test
    public void smokeTest() {
        Location francescMacia = new Location(41.3925603, 2.1418532);
        Location placaCatalunya = new Location(41.3870194,2.1678584);

        // More or less 2km from Francesc Macia to Placa Catalunya
        assertEquals(2.0, DistanceCalculator.calculateDistance(francescMacia, placaCatalunya), 0.5);
    }

    @Test
    public void distanceFurtherThan5Km() {
        Location pickup = new Location(41.3925603, 2.1418532);
        Location delivery = new Location(41.3470194,2.1678584);

        assertTrue(DistanceCalculator.calculateDistance(pickup, delivery) > 5);
        assertEquals(5.0, DistanceCalculator.calculateDistance(pickup, delivery), 0.6);
    }

    @Test
    public void distanceLessThan5Km() {
        Location pickup = new Location(41.38005925397267, 2.16826435705024);
        Location delivery = new Location(41.3470194,2.1678584);

        assertTrue(DistanceCalculator.calculateDistance(pickup, delivery) < 5);
        assertEquals(3.0, DistanceCalculator.calculateDistance(pickup, delivery), 0.7);
    }

}