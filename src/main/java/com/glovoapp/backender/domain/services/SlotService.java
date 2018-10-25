package com.glovoapp.backender.domain.services;

import com.glovoapp.backender.domain.maker.SlotMaker;
import com.glovoapp.backender.domain.viewer.SlotVM;
import com.glovoapp.backender.domain.viewer.ViewOrder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SlotService {

    @Value("${backender.slots}")
    private String slots;

    private int index = 0;

    public List<SlotVM> getSlotVM() {
        if (slots == null || slots.trim().length() == 0)
            return new ArrayList<>();

        String[] split = slots.split(";");
        return Arrays
                .stream(split)
                .map(s -> s.split("-"))
                .map(SlotMaker::toSlotVM)
                .collect(Collectors.toList());
    }

    public List<SlotVM> getSlots(List<ViewOrder> viewOrderList) {
        index = 0;

        List<SlotVM> slotList = getSlotVM();
        slotList.forEach(slot -> slot.setViewOrders(getViewOrders(viewOrderList, slot)));
        return slotList;
    }

    private List<ViewOrder> getViewOrders(List<ViewOrder> viewOrderList, SlotVM slot) {
        List<ViewOrder> result = new ArrayList<>();
        while (index < viewOrderList.size()) {
            ViewOrder viewOrder = viewOrderList.get(index);
            if (slotContainsOrderDistance(slot, viewOrder))
                result.add(viewOrder);
            if (viewOrder.getDistance() > slot.getFinalDistance())
                break;
            index++;
        }

        return result;
    }

    private boolean slotContainsOrderDistance(SlotVM slot, ViewOrder viewOrder) {
        return (viewOrder.getDistance() > slot.getInitDistance()) && (viewOrder.getDistance() < slot.getFinalDistance());
    }

}
