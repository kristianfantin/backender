package com.glovoapp.backender.domain.maker;

import com.glovoapp.backender.domain.Courier;
import com.glovoapp.backender.domain.viewer.CourierVM;

public class CourierMaker {

    public static CourierVM toCourierVM(Courier courier) {
        CourierVM vm = new CourierVM();
        vm.setId(courier.getId());
        vm.setName(courier.getName());
        vm.setBox(courier.getBox());
        vm.setVehicle(courier.getVehicle());
        return vm;
    }

}
