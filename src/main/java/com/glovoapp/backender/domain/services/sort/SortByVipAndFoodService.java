package com.glovoapp.backender.domain.services.sort;

import com.glovoapp.backender.domain.viewer.SlotVM;
import com.glovoapp.backender.domain.viewer.ViewOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortByVipAndFoodService implements SortService {

    public List<SlotVM> getSlots(List<SlotVM> list) {
        list.forEach(slotVM -> slotVM.setViewOrders(getSort(slotVM.getViewOrders())));
        return list;
    }

    private List<ViewOrder> getSort(List<ViewOrder> viewOrders) {
        viewOrders.sort((o1, o2) -> {
            int compare = o2.getVip().compareTo(o1.getVip());
            if (compare != 0)
                return compare;

            return o2.getFood().compareTo(o1.getFood());
        });
        return viewOrders;
    }

}
