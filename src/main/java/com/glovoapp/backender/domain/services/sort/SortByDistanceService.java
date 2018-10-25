package com.glovoapp.backender.domain.services.sort;

import com.glovoapp.backender.domain.viewer.ViewOrder;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class SortByDistanceService {

    public List<ViewOrder> getSort(List<ViewOrder> viewOrders) {
        viewOrders.sort(Comparator.comparing(ViewOrder::getDistance));
        return viewOrders;
    }
}
