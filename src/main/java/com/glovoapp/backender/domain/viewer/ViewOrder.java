package com.glovoapp.backender.domain.viewer;

import com.glovoapp.backender.domain.Courier;
import com.glovoapp.backender.domain.Order;

public class ViewOrder {

    private Courier courier;
    private Order order;
    private Double distance;
    private Boolean vip;
    private Boolean food;

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Boolean getVip() {
        return vip;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }

    public Boolean getFood() {
        return food;
    }

    public void setFood(Boolean food) {
        this.food = food;
    }
}
