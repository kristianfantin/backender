package com.glovoapp.backender.domain.viewer;

/**
 * To be used for exposing order information through the API
 */
public class OrderVM {
    private String id;
    private String description;
    private Double distance;
    private Boolean vip;
    private Boolean food;

    public OrderVM(String id, String description, Double distance, Boolean vip, Boolean food) {
        this.id = id;
        this.description = description;
        this.distance = distance;
        this.vip = vip;
        this.food = food;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Double getDistance() {
        return distance;
    }

    public Boolean getVip() {
        return vip;
    }

    public Boolean getFood() {
        return food;
    }
}
