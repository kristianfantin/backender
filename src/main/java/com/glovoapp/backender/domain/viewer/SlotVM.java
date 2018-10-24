package com.glovoapp.backender.domain.viewer;

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

    public void setViewOrders(List<ViewOrder> viewOrders) {
        this.viewOrders = viewOrders;
    }

    public List<ViewOrder> getViewOrders() {
        return viewOrders;
    }
}
