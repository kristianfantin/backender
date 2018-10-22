package com.glovoapp.backender.domain.viewer;

import java.util.ArrayList;
import java.util.List;

public class SlotVM {

    private Double initDistance;
    private Double finalDistance;
    private List<ViewOrder> viewOrders;

    public Double getInitDistance() {
        return initDistance;
    }

    public void setInitDistance(Double initDistance) {
        this.initDistance = initDistance;
    }

    public Double getFinalDistance() {
        return finalDistance;
    }

    public void setFinalDistance(Double finalDistance) {
        this.finalDistance = finalDistance;
    }

    public List<ViewOrder> getViewOrders() {
        if (viewOrders == null)
            return new ArrayList<>();
        return viewOrders;
    }

    public void setViewOrders(ViewOrder viewOrder) {
        this.viewOrders = getViewOrders(viewOrder);
    }

    private List<ViewOrder> getViewOrders(ViewOrder viewOrder) {
        getViewOrders().add(viewOrder);
        return getViewOrders();
    }

}
