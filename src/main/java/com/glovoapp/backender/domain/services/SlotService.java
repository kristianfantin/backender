package com.glovoapp.backender.domain.services;

import com.glovoapp.backender.domain.viewer.SlotVM;
import com.glovoapp.backender.domain.viewer.ViewOrder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.glovoapp.backender.domain.services.OrderBy.*;

@Service
public class SlotService {

    @Value("${backender.slots}")
    private String slots;

    public List<SlotVM> getSlotVM() {
        String[] split = slots.split(";");
        return Arrays
                .stream(split).map(s -> s.split("-"))
                .map(this::getSlotVM)
                .collect(Collectors.toList());
    }

    public List<SlotVM> getSlots(List<ViewOrder> viewOrderList) {
        int index = 0;
        List<SlotVM> slotList = getSlotVM();
        for (SlotVM slot : slotList)
            index = updateOrdersFromSlot(viewOrderList, index, slot);

        return slotList;
    }

    private int updateOrdersFromSlot(List<ViewOrder> viewOrderList, int index, SlotVM slot) {
        boolean gotIn = false;
        ViewOrder viewOrder = viewOrderList.get(index);
        List<ViewOrder> viewOrders = new ArrayList<>();
        while(slotContainsOrderDistance(slot, viewOrder)) {
            viewOrders.add(viewOrder);

            gotIn = true;
            index++;
            viewOrder = viewOrderList.get(index);
        }
        if (!gotIn)
            index++;

        slot.setViewOrders(viewOrders);
        return index;
    }

    private boolean slotContainsOrderDistance(SlotVM slot, ViewOrder viewOrder) {
        return (viewOrder.getDistance() > slot.getInitDistance()) && (viewOrder.getDistance() < slot.getFinalDistance());
    }

    private SlotVM getSlotVM(String[] distance) {
        SlotVM slotVM = new SlotVM();
        slotVM.setInitDistance(Double.valueOf(distance[0]));
        slotVM.setFinalDistance(Double.valueOf(distance[1]));
        return slotVM;
    }

    public List<SlotVM> getSlotsOrderByVip(List<SlotVM> list) {
        list.forEach(slotVM -> slotVM.setViewOrders(VIP.getSort(slotVM.getViewOrders())));
        return list;
    }

    public List<SlotVM> getSlotsOrderByFood(List<SlotVM> list) {
        list.forEach(slotVM -> slotVM.setViewOrders(FOOD.getSort(slotVM.getViewOrders())));
        return list;
    }

    public List<SlotVM> getSlotsOrderByVidAndFood(List<SlotVM> list) {
        list.forEach(slotVM -> slotVM.setViewOrders(VIP_FOOD.getSort(slotVM.getViewOrders())));
        return list;
    }

    public List<SlotVM> getSlotsOrderByFoodAndVip(List<SlotVM> list) {
        list.forEach(slotVM -> slotVM.setViewOrders(FOOD_VIP.getSort(slotVM.getViewOrders())));
        return list;
    }
}
