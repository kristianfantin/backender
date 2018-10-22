package com.glovoapp.backender;

import com.glovoapp.backender.domain.Courier;
import com.glovoapp.backender.domain.Location;
import com.glovoapp.backender.domain.type.Vehicle;
import com.glovoapp.backender.repositories.CourierRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourierRepositoryTest {
    @Test
    void findOneExisting() {
        Courier courier = new CourierRepository().findById("courier-1");
        Courier expected = new Courier().withId("courier-1")
                .withBox(true)
                .withName("Manolo Escobar")
                .withVehicle(Vehicle.MOTORCYCLE)
                .withLocation(new Location(41.3965463, 2.1963997));

        assertEquals(expected, courier);
    }

    @Test
    void findOneNotExisting() {
        Courier courier = new CourierRepository().findById("bad-courier-id");
        assertNull(courier);
    }

    @Test
    void findAll() {
        List<Courier> all = new CourierRepository().findAll();
        assertFalse(all.isEmpty());
    }
}