package com.glovoapp.backender.domain.services;

import com.glovoapp.backender.domain.viewer.ViewOrder;

import java.util.List;

interface SortService {

    List<ViewOrder> getSort(List<ViewOrder> viewOrders);

}
