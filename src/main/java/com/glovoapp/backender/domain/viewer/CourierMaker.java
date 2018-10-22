package com.glovoapp.backender.domain.viewer;

import com.glovoapp.backender.domain.Courier;

public class CourierMaker {

    public CourierVM toCourierVM(Courier courier) {
        CourierVM vm = new CourierVM();
        vm.setId(courier.getId());
        vm.setName(courier.getName());
        vm.setBox(courier.getBox());
        vm.setVehicle(courier.getVehicle());
        return vm;
    }

}
