package com.glovoapp.backender.domain.services;

import com.glovoapp.backender.domain.viewer.SlotVM;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    private SlotVM getSlotVM(String[] distance) {
        SlotVM slotVM = new SlotVM();
        slotVM.setInitDistance(Double.valueOf(distance[0]));
        slotVM.setFinalDistance(Double.valueOf(distance[1]));
        return slotVM;
    }


}
