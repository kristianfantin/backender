package com.glovoapp.backender.domain;

import java.util.Objects;

public class Order {
    private String id;
    private String description;
    private Boolean food;
    private Boolean vip;
    private Location pickup;
    private Location delivery;

    public String getId() {
        return id;
    }

    public Order withId(String id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Order withDescription(String description) {
        this.description = description;
        return this;
    }

    public Boolean getFood() {
        return food;
    }

    public Order withFood(Boolean food) {
        this.food = food;
        return this;
    }

    public Boolean getVip() {
        return vip;
    }

    public Order withVip(Boolean vip) {
        this.vip = vip;
        return this;
    }

    public Location getPickup() {
        return pickup;
    }

    public Order withPickup(Location pickup) {
        this.pickup = pickup;
        return this;
    }

    public Location getDelivery() {
        return delivery;
    }

    public Order withDelivery(Location delivery) {
        this.delivery = delivery;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(description, order.description) &&
                Objects.equals(food, order.food) &&
                Objects.equals(vip, order.vip) &&
                Objects.equals(pickup, order.pickup) &&
                Objects.equals(delivery, order.delivery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, food, vip, pickup, delivery);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", food=" + food +
                ", vip=" + vip +
                ", pickup=" + pickup +
                ", delivery=" + delivery +
                '}';
    }
}
