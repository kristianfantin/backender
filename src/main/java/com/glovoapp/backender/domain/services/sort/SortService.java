package com.glovoapp.backender.domain.services.sort;

import com.glovoapp.backender.domain.viewer.SlotVM;

import java.util.List;

interface SortService {

    List<SlotVM> getSlots(List<SlotVM> list);

}
