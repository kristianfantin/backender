package com.glovoapp.backender.domain.services;

import com.glovoapp.backender.domain.viewer.ViewOrder;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
class SortService {

    List<ViewOrder> getSortByDistance(List<ViewOrder> viewOrders) {
        viewOrders.sort(Comparator.comparing(ViewOrder::getDistance));
        return viewOrders;
    }

    List<ViewOrder> getSortByVip(List<ViewOrder> viewOrders) {
        viewOrders.sort((ViewOrder order1, ViewOrder order2) -> order2.getVip().compareTo(order1.getVip()));
        return viewOrders;
    }

    List<ViewOrder> getSortByFood(List<ViewOrder> viewOrders) {
        viewOrders.sort((ViewOrder order1, ViewOrder order2) -> order2.getFood().compareTo(order1.getFood()));
        return viewOrders;
    }

    List<ViewOrder> getSortByVipAndFood(List<ViewOrder> viewOrders) {
        viewOrders.sort((o1, o2) -> {
            int compare = o2.getVip().compareTo(o1.getVip());
            if (compare != 0)
                return compare;

            return o2.getFood().compareTo(o1.getFood());
        });
        return viewOrders;
    }

    List<ViewOrder> getSortByFoodAndVip(List<ViewOrder> viewOrders) {
        viewOrders.sort((o1, o2) -> {
            int compare = o2.getFood().compareTo(o1.getFood());
            if (compare != 0)
                return compare;

            return o2.getVip().compareTo(o1.getVip());
        });
        return viewOrders;
    }
}
