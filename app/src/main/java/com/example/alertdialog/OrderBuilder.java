package com.example.alertdialog;

public interface OrderBuilder {
    OrderBuilder setLocation(Location location);
    OrderBuilder setSauceType(SauceType sauceType);
    OrderBuilder setVegetableType(VegetableType vegetableType);
    OrderBuilder setBreadType(BreadType breadType);
    Order build();
}
