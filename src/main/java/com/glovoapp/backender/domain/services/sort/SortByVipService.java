package com.glovoapp.backender.domain.services.sort;

import com.glovoapp.backender.domain.viewer.SlotVM;
import com.glovoapp.backender.domain.viewer.ViewOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortByVipService implements SortService {

    public List<SlotVM> getSlots(List<SlotVM> list) {
        list.forEach(slotVM -> slotVM.setViewOrders(getSort(slotVM.getViewOrders())));
        return list;
    }

    private List<ViewOrder> getSort(List<ViewOrder> viewOrders) {
        viewOrders.sort((ViewOrder order1, ViewOrder order2) -> order2.getVip().compareTo(order1.getVip()));
        return viewOrders;
    }

}
