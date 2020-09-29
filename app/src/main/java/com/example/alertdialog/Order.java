package com.example.alertdialog;

public class Order {
    private Location location;
    private SauceType sauceType;
    private VegetableType vegetableType;
    private BreadType breadType;

    public Order(Location location, SauceType sauceType, VegetableType vegetableType, BreadType breadType) {
        this.location = location;
        this.sauceType = sauceType;
        this.vegetableType = vegetableType;
        this.breadType = breadType;
    }

    public Location getLocation() {
        return location;
    }

    public SauceType getSauceType() {
        return sauceType;
    }

    public VegetableType getVegetableType() {
        return vegetableType;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setSauceType(SauceType sauceType) {
        this.sauceType = sauceType;
    }

    public void setVegetableType(VegetableType vegetableType) {
        this.vegetableType = vegetableType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    @Override
    public String toString() {
        return "Order{" +
                "location=" + location +
                ", sauceType=" + sauceType +
                ", vegetableType=" + vegetableType +
                ", breadType=" + breadType +
                '}';
    }

    static class Builder implements OrderBuilder {
        private Location location;
        private SauceType sauceType;
        private VegetableType vegetableType;
        private BreadType breadType;

        @Override
        public OrderBuilder setLocation(Location location) {
            this.location = location;
            return this;
        }

        @Override
        public OrderBuilder setSauceType(SauceType sauceType) {
            this.sauceType = sauceType;
            return this;
        }

        @Override
        public OrderBuilder setVegetableType(VegetableType vegetableType) {
            this.vegetableType = vegetableType;
            return this;
        }

        @Override
        public OrderBuilder setBreadType(BreadType breadType) {
            this.breadType = breadType;
            return this;
        }

        @Override
        public Order build() {
            return new Order(location,sauceType, vegetableType, breadType);
        }
    }
}