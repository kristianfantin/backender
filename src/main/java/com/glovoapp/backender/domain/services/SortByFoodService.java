package com.glovoapp.backender.domain.services;

import com.glovoapp.backender.domain.viewer.ViewOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class SortByFoodService implements SortService {

    public List<ViewOrder> getSort(List<ViewOrder> viewOrders) {
        viewOrders.sort((ViewOrder order1, ViewOrder order2) -> order2.getFood().compareTo(order1.getFood()));
        return viewOrders;
    }
}
