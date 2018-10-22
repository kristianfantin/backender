package com.glovoapp.backender.domain;

import com.glovoapp.backender.domain.type.Vehicle;

import java.util.Objects;

public class Courier {
    private String id;
    private String name;
    private Boolean box;
    private Vehicle vehicle;
    private Location location;

    public String getId() {
        return id;
    }

    String getName() {
        return name;
    }

    public Boolean getBox() {
        return box;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Location getLocation() {
        return location;
    }

    public Courier withId(String id) {
        this.id = id;
        return this;
    }

    public Courier withName(String name) {
        this.name = name;
        return this;
    }

    public Courier withBox(Boolean box) {
        this.box = box;
        return this;
    }

    public Courier withVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public Courier withLocation(Location location) {
        this.location = location;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Courier courier = (Courier) o;
        return Objects.equals(id, courier.id) &&
                Objects.equals(name, courier.name) &&
                Objects.equals(box, courier.box) &&
                vehicle == courier.vehicle &&
                Objects.equals(location, courier.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, box, vehicle, location);
    }

    @Override
    public String toString() {
        return "Courier{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", box=" + box +
                ", vehicle=" + vehicle +
                ", location=" + location +
                '}';
    }
}
