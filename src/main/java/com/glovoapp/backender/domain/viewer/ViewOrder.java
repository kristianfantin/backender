package com.glovoapp.backender.domain.viewer;

public class ViewOrder {

    private CourierVM courier;
    private OrderVM order;
    private Double distance;
    private Boolean vip;
    private Boolean food;

    public CourierVM getCourier() {
        return courier;
    }

    public void setCourier(CourierVM courier) {
        this.courier = courier;
    }

    public OrderVM getOrder() {
        return order;
    }

    public void setOrder(OrderVM order) {
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
