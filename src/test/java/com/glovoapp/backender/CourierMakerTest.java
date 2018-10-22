package com.glovoapp.backender;

import com.glovoapp.backender.domain.Courier;
import com.glovoapp.backender.domain.viewer.CourierMaker;
import com.glovoapp.backender.domain.viewer.CourierVM;
import com.glovoapp.backender.repositories.CourierRepository;
import org.junit.jupiter.api.Test;

import static com.glovoapp.backender.domain.type.Vehicle.MOTORCYCLE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class CourierMakerTest {

    @Test
    void happyDay() {
        Courier courier = new CourierRepository().findById("courier-1");
        CourierVM courierVM = new CourierMaker().toCourierVM(courier);
        assertEquals("Manolo Escobar", courierVM.getName());
        assertTrue(courierVM.getBox());
        assertEquals(MOTORCYCLE, courierVM.getVehicle());
    }
}
