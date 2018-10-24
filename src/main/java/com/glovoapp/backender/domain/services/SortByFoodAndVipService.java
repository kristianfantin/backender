package com.glovoapp.backender.domain.services;

import com.glovoapp.backender.domain.viewer.ViewOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class SortByFoodAndVipService implements SortService {

    public List<ViewOrder> getSort(List<ViewOrder> viewOrders) {
        viewOrders.sort((o1, o2) -> {
            int compare = o2.getFood().compareTo(o1.getFood());
            if (compare != 0)
                return compare;

            return o2.getVip().compareTo(o1.getVip());
        });
        return viewOrders;
    }
}
