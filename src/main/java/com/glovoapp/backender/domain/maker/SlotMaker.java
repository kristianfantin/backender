package com.glovoapp.backender.domain.maker;

import com.glovoapp.backender.domain.viewer.SlotVM;

import java.util.ArrayList;

public class SlotMaker {

    public static SlotVM toSlotVM(String[] distances) {
        SlotVM slotVM = new SlotVM();
        slotVM.setInitDistance(Double.valueOf(distances[0]));
        slotVM.setFinalDistance(Double.valueOf(distances[1]));
        slotVM.setViewOrders(new ArrayList<>());
        return slotVM;
    }
}
